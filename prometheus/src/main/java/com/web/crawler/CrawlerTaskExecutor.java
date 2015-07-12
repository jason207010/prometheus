package com.web.crawler;

import com.web.task.TaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jayson   2015-07-12 16:45
 * @since v1.0
 */
@Component("CrawlerTaskExecutor")
public class CrawlerTaskExecutor implements TaskExecutor<CrawlerTask> {
    private ExecutorService pool = Executors.newCachedThreadPool();
    @Override
    public void execute(CrawlerTask task) {
        pool.execute(task);
    }
}