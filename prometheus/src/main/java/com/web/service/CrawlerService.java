package com.web.service;

import com.web.task.CrawlerTask;

import java.util.List;

/**
 * @author jayson   2015-07-10-14:33
 * @since v1.0
 */
public interface CrawlerService {
    public void addTask(CrawlerTask task);
    public List<CrawlerTask> tasks();
}
