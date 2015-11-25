package com.web.executor.lucene;

import com.web.executor.TaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jayson  <br/> 2015-11-25 18:01
 * @since v1.0
 */
@Component("LuceneTaskExecutor")
public class LuceneTaskExecutor implements TaskExecutor<LuceneTask> {

    private ExecutorService pool = Executors.newCachedThreadPool();

    @Override
    public void execute(LuceneTask task) {
        pool.execute(()->{
            task.execute();
        });
    }
}