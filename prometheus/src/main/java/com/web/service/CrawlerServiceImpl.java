package com.web.service;

import com.web.crawler.CrawlerTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jayson   2015-07-10-14:26
 * @since v1.0
 */
@Service("CrawlerServiceImpl")
public class CrawlerServiceImpl implements CrawlerService {
    @Autowired
    private CrawlerTaskService manager;

    @Override
    public void addTask(CrawlerTask task) {
        manager.addTask(task);
    }

    @Override
    public void removeTask(long id) {
        manager.removeTask(id);
    }

    @Override
    public List<CrawlerTask> tasks() {
        return manager.tasks();
    }
}