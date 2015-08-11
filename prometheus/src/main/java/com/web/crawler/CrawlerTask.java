package com.web.crawler;

import com.web.entity.CrawlerInfoEntity;
import com.web.task.Task;

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
