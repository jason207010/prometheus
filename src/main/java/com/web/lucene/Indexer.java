package com.web.lucene;

import com.web.config.Config;
import com.web.util.LuceneUtils;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author Jayson Chan<br/>2015-11-13 16:23
 * @since v1.0
 */
@Component("Indexer")
public class Indexer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Indexer.class);

    @Autowired
    private Config config;

    public void saveOrUpdate(Term term , Document document){
        IndexWriter indexWriter = null;
        try {
            indexWriter = LuceneUtils.getIndexWriter(config.get("indexPath"));
            indexWriter.updateDocument(term , document);
        } catch (IOException e) {
            LOGGER.error("" , e);
        } finally {
            LuceneUtils.closeGracefully(indexWriter);
        }
    }
}
