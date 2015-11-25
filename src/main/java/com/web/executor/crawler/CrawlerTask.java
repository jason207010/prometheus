package com.web.executor.crawler;

import com.web.crawler.Crawler;
import com.web.crawler.CrawlerStatus;
import com.web.executor.Task;

/**
 * @author jayson   2015-08-11 17:41
 * @since v1.0
 */
public interface CrawlerTask extends Task {
    public void stop();
    public CrawlerStatus getStatus();
    public Crawler getCrawler();
    public void setCrawler(Crawler crawler);
}
