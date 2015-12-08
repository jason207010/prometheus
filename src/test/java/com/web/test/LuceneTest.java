package com.web.test;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * @author jayson   2015-07-22-14:59
 * @since v1.0
 */
public class LuceneTest {
    @Test
    public void test() throws IOException, ParseException {
        Directory directory = FSDirectory.open(Paths.get("d:\\data1\\lucene"));
        Analyzer analyzer = new IKAnalyzer();
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
        indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
        IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
        Document document = new Document();
        document.add(new StringField("title" , "Bill Cosby loses latest legal bid to block sexual abuse lawsuit", Field.Store.YES));
        document.add(new TextField("content", "The accuser's attorney, Gloria Allred, said the decision cleared the way for the litigation brought by Judy Huth, now in her 50s, to proceed, and that she intended to take Cosby's sworn deposition within the next 30 days." , Field.Store.YES));
        indexWriter.updateDocument(new Term("title" , "Bill Cosby loses latest legal bid to block sexual abuse lawsuit") , document);
        document = new Document();
        document.add(new StringField("title", "BillMarines braved gunfire to save comrades in Chattanooga ", Field.Store.YES));
        document.add(new TextField("content", "The FBI is investigating whether Abdulazeez had any ties to terrorists. The FBI seized personal notes from his house that hinted at extremist views. ", Field.Store.YES));
        indexWriter.updateDocument(new Term("title" , "BillMarines braved gunfire to save comrades in Chattanooga ") , document);
        indexWriter.close();

        DirectoryReader directoryReader = DirectoryReader.open(directory);
        IndexSearcher indexSearcher = new IndexSearcher(directoryReader);
        String fields[] = {"title" , "content"};
        MultiFieldQueryParser multiFieldQueryParser = new MultiFieldQueryParser(fields, analyzer);
        Query query = multiFieldQueryParser.parse("FBI");
        TopScoreDocCollector collector = TopScoreDocCollector.create(10);
        indexSearcher.search(query , collector);
        TopDocs topDocs = collector.topDocs();
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for(ScoreDoc d : scoreDocs){
            Document doc = indexSearcher.doc(d.doc);
            System.out.println(doc.get("title"));
            System.out.println(doc.get("content"));
            System.out.println("=====================");
        }
    }
}
