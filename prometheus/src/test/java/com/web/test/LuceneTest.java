package com.web.test;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * @author jayson   2015-07-22-14:59
 * @since v1.0
 */
public class LuceneTest {
    @Test
    public void test() throws IOException, ParseException {
        Directory directory = FSDirectory.open(Paths.get("E:\\data\\lucene"));
        StandardAnalyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
        IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
        Document document = new Document();
        String text = "This is the text to be indexed.\n text is good";
        document.add(new Field("fieldname", text, TextField.TYPE_STORED));
        indexWriter.addDocument(document);
        indexWriter.close();

        DirectoryReader reader = DirectoryReader.open(directory);
        IndexSearcher indexSearcher = new IndexSearcher(reader);

        QueryParser queryParser = new QueryParser("fieldname", analyzer);
        Query query = queryParser.parse("text");
        ScoreDoc[] scoreDocs = indexSearcher.search(query, 1000).scoreDocs;
        for(ScoreDoc sd : scoreDocs){
            Document doc = indexSearcher.doc(sd.doc);
            String s = doc.get("fieldname");
            System.out.println(sd.doc);
            System.out.println(s);
        }
    }
}
