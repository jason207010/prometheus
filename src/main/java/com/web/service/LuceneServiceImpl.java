package com.web.service;

import com.web.common.Page;
import com.web.config.Config;
import com.web.entity.WebPageEntity;
import com.web.lucene.Indexer;
import com.web.lucene.SearchResult;
import com.web.lucene.Searcher;
import com.web.util.ConverseUtil;
import org.apache.lucene.document.*;
import org.apache.lucene.index.Term;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jayson   2015-07-22-14:59
 * @since v1.0
 */
@Service("LuceneServiceImpl")
public class LuceneServiceImpl implements LuceneService {

    @Autowired
    private Indexer indexer;

    @Autowired
    private Config config;

    @Autowired
    private Searcher searcher;

    @Override
    public void saveOrUpdate(WebPageEntity entity) {
        Document document = new Document();
        document.add(new LongField(config.get("id"), entity.getId(), Field.Store.YES));
        document.add(new StringField(config.get("crc") , String.valueOf(entity.getCrc()), Field.Store.YES));
        document.add(new StringField(config.get("url") , entity.getUrl() , Field.Store.YES));
        document.add(new StringField(config.get("viceUrl") , entity.getViceUrl() , Field.Store.YES));
        document.add(new StringField(config.get("md5") , entity.getMd5() , Field.Store.YES));
        document.add(new StringField(config.get("author") , entity.getAuthor() , Field.Store.YES));
        document.add(new StringField(config.get("articleTitle") , entity.getArticleTitle() , Field.Store.YES));
        document.add(new TextField(config.get("articleBody"), entity.getArticleBody(), Field.Store.YES));
        Term term = new Term(config.get("url"), entity.getUrl() + entity.getViceUrl());
        indexer.saveOrUpdate(term , document);
    }

    @Override
    public Page<SearchResult> search(String keyWord, Page<SearchResult> page) {
        return searcher.search(keyWord , page);
    }
}