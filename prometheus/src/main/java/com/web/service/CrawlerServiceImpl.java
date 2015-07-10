package com.web.service;

import com.web.task.CrawlerTask;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jayson   2015-07-10-14:26
 * @since v1.0
 */
@Service("CrawlerServiceImpl")
public class CrawlerServiceImpl implements CrawlerService {
    private ExecutorService pool = Executors.newCachedThreadPool();
    private Map<Long , CrawlerTask> tasks = new ConcurrentHashMap<>();

    @Override
    public void addTask(CrawlerTask task) {
        pool.execute(task);
        tasks.put(task.getId() , task);
    }

    @Override
    public List<CrawlerTask> tasks() {
        return null;
    }
}