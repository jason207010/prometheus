package com.web.lucene;

import com.web.config.Config;
import com.web.util.ConverseUtil;
import com.web.util.LuceneUtils;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Jayson Chan<br/>2015-11-13 16:23
 * @since v1.0
 */
@Component("Indexer")
public class Indexer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Indexer.class);

    @Autowired
    private Config config;

    private BlockingQueue<File> indexPaths = new LinkedBlockingQueue<>();

    private ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);

    @PostConstruct
    public void init() throws IOException {
        int indexNum = ConverseUtil.converseInt(config.get("indexNum"));
        for(int i = 0 ; i < indexNum ; ++i){
            File file = new File(config.get("indexPath") + File.separator + i);
            if(file.exists())
                file.createNewFile();

            indexPaths.offer(file);
        }

        if(indexPaths.isEmpty())
            throw new IllegalStateException();
    }

    public void saveOrUpdate(Term term , Document document){
        threadPool.execute(() -> {
            IndexWriter indexWriter = null;
            File file = null;
            try {
                file = indexPaths.take();
                indexWriter = LuceneUtils.getIndexWriter(file.getPath());
                indexWriter.updateDocument(term , document);
            } catch (Exception e) {
                LOGGER.error("" , e);
            } finally {
                LuceneUtils.closeGracefully(indexWriter);
                if(file != null)
                    indexPaths.offer(file);
            }
        });
    }

    @PreDestroy
    public void onDestroy(){
    }

}
