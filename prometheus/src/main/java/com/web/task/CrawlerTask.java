package com.web.task;

import com.web.crawler.CrawlerContext;

/**
 * @author jayson   2015-07-09-12:13
 * @since v1.0
 */
public abstract class CrawlerTask implements Runnable , CrawlerContext {
    public abstract void before();
    public abstract void after();

    @Override
    public void run() {
        before();
        start();
        after();
    }
}
