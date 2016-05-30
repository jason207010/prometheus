package com.web.lucene;

import com.web.common.Page;
import com.web.config.Config;
import com.web.util.ConverseUtil;
import com.web.util.LuceneUtils;
import com.web.util.SpringFactory;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.MultiReader;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.*;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.store.FSDirectory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jayson Chan<br/>2015-11-13 17:50
 * @since v1.0
 */
@Component("Searcher")
public class Searcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(Searcher.class);

    @Autowired
    private Config config;

    @Autowired
    private SpringFactory factory;

    public Page<SearchResult> search(String keyWord , Page<SearchResult> page){
        MultiReader multiReader = null;
        try {

            File file = new File(config.get("indexPath"));
            File[] files = file.listFiles();

            if(files == null || files.length == 0)
                return page;

            IndexReader[] indexReaders = new IndexReader[files.length];
            for(int i = 0 ; i < indexReaders.length ; ++i)
                indexReaders[i] = DirectoryReader.open(FSDirectory.open(Paths.get(files[i].getPath())));

            multiReader = new MultiReader(indexReaders);

            IndexSearcher searcher = new IndexSearcher(multiReader);
            Analyzer analyzer = new IKAnalyzer();
            String[] fields = {config.get("articleTitle") , config.get("articleBody")};
            MultiFieldQueryParser parser = new MultiFieldQueryParser(fields, analyzer);
            Query query = parser.parse(keyWord);
            TopScoreDocCollector collector = TopScoreDocCollector.create(ConverseUtil.converseInt(config.get("hits")));
            searcher.search(query, collector);

            TopDocs topDocs = collector.topDocs(page.getStart() - 1, page.getPageSize());
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            page.setTotal(collector.getTotalHits());

            SimpleHTMLFormatter formatter = new SimpleHTMLFormatter("<font color='red'>" , "</font>");
            Highlighter highlighter = new Highlighter(formatter, new QueryScorer(query));

            List<SearchResult> list = new ArrayList<>();
            for(int i = 0 ; i < scoreDocs.length ; ++i){
                SearchResult result = factory.create(SearchResult.class);
                int doc = scoreDocs[i].doc;
                Document document = searcher.doc(doc);
                result.setCrc(ConverseUtil.converseLong(document.get(config.get("crc"))));
                result.setUrl(document.get(config.get("url")));
                result.setViceUrl(document.get(config.get("viceUrl")));
                result.setAuthor(document.get(config.get("author")));

                String articleTitle = document.get(config.get("articleTitle"));
                if(!"".equals(articleTitle)){
                    try {
                        String _articleTitle = highlighter.getBestFragment(analyzer, config.get("articleTitle"), articleTitle);
                        if(_articleTitle != null)
                            articleTitle = _articleTitle;
                    } catch (InvalidTokenOffsetsException e) {
                        e.printStackTrace();
                    }
                }

                result.setArticleTitle(articleTitle);

                String articleBody = document.get(config.get("articleBody"));
                if(!"".equals(articleBody)){
                    try {
                        String _articleBody = highlighter.getBestFragment(analyzer , config.get("articleBody") , articleBody);
                        if(_articleBody != null)
                            articleBody = _articleBody;
                    } catch (InvalidTokenOffsetsException e) {

                    }
                }
                result.setArticleBody(articleBody);
                list.add(result);
            }
            page.setList(list);
        } catch (IOException e) {
            LOGGER.error("" , e);
        } catch (ParseException e) {
            LOGGER.error("" , e);
        } finally {
            LuceneUtils.closeGracefully(multiReader);
        }
        return page;
    }
}