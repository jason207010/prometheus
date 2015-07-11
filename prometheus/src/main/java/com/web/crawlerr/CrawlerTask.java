package com.web.crawlerr;

/**
 * @author jayson   2015-07-11-16:58
 * @since v1.0
 */
public interface CrawlerTask {
    public void start();
    public void stop();
    public CrawlerTaskStatus status();
}
