package com.web.util;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.FSDirectory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.Closeable;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * @author Jayson Chan<br/>2015-11-13 16:54
 * @since v1.0
 */
public final class LuceneUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(LuceneUtils.class);

    public static IndexWriter getIndexWriter(String path) throws IOException {
        FSDirectory directory = FSDirectory.open(Paths.get(path));
        Analyzer analyzer = new IKAnalyzer();
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
        indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
        IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
        return indexWriter;
    }

    public static IndexSearcher getIndexSearcher(String path) throws IOException {
        FSDirectory directory = FSDirectory.open(Paths.get(path));
        DirectoryReader reader = DirectoryReader.open(directory);
        IndexSearcher indexSearcher = new IndexSearcher(reader);
        return indexSearcher;
    }

    public static void closeGracefully(Closeable object){
        if(object != null){
            try {
                object.close();
            } catch (IOException e) {
                LOGGER.error("" , e);
            }
        }
    }
}
