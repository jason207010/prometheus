package com.web.service;

import com.web.config.Config;
import com.web.crawler.CrawlerInfo;
import com.web.executor.TaskExecutor;
import com.web.executor.crawler.CrawlerTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jayson   2015-07-12 13:38
 * @since v1.0
 */
@Service("CrawlerTaskServiceImpl")
public class CrawlerTaskServiceImpl implements CrawlerTaskService {
    @Resource(name = "CrawlerTaskExecutor")
    private TaskExecutor<CrawlerTask> executor;

    @Autowired
    private Config config;

    private Map<Long , CrawlerTask> tasks = new HashMap<>();

    @Override
    public void addTask(CrawlerTask task) {
        executor.execute(task);
        CrawlerInfo crawlerInfo = task.getCrawler().getCrawlerInfo();
        tasks.put(crawlerInfo.getId() , task);
    }

    @Override
    public void removeTask(long id) {
        CrawlerTask task = tasks.get(id);
        if(task == null)
            return;

        tasks.remove(task);
        task.stop();
    }

    @Override
    public List<CrawlerTask> tasks() {
        List<CrawlerTask> list = new ArrayList<>();
        list.addAll(tasks.values());
        return list;
    }
}