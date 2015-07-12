package com.web.crawler;

import com.web.task.Task;

/**
 * @author jayson   2015-07-11-16:58
 * @since v1.0
 */
public abstract class CrawlerTask implements Task , Runnable {
    private CrawlerContext context;

    public abstract void stop();
    public abstract CrawlerTaskStatus status();

    @Override
    public void run() {
        execute();
    }

    /**getter¡¢setter·½·¨**/
    public CrawlerContext getContext() {
        return context;
    }

    public void setContext(CrawlerContext context) {
        this.context = context;
    }
}
