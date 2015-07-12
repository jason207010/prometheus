package com.web.service;

import com.web.crawler.CrawlerTask;

import java.util.List;

/**
 * @author jayson   2015-07-12 13:38
 * @since v1.0
 */
public interface CrawlerTaskService {
    public void addTask(CrawlerTask task);
    public void removeTask(long id);
    public List<CrawlerTask> tasks();
}
