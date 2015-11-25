package com.web.service;

import com.web.config.Config;
import com.web.executor.crawler.CrawlerTask;
import com.web.dao.CrawlerInfoDao;
import com.web.entity.CrawlerInfoEntity;
import com.web.executor.TaskExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author jayson   2015-07-12 13:38
 * @since v1.0
 */
@Service("CrawlerTaskServiceImpl")
public class CrawlerTaskServiceImpl implements CrawlerTaskService {
    @Resource(name = "CrawlerTaskExecutor")
    private TaskExecutor<CrawlerTask> executor;

    @Autowired
    private CrawlerInfoDao crawlerTaskDao;

    @Autowired
    private Config config;

    private Map<Long , CrawlerTask> tasks = new HashMap<>();

    @Override
    public void addTask(CrawlerTask task) {
        executor.execute(task);
        CrawlerInfoEntity crawlerInfo = task.getCrawler().getCrawlerInfo();

        if(crawlerInfo.getId() > config.getStartId())
            crawlerTaskDao.save(crawlerInfo);

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