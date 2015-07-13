package com.web.service;

import com.web.crawler.CrawlerTask;
import com.web.task.TaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * @author jayson   2015-07-12 13:38
 * @since v1.0
 */
@Service("CrawlerTaskServiceImpl")
public class CrawlerTaskServiceImpl implements CrawlerTaskService {
    @Resource(name = "CrawlerTaskExecutor")
    private TaskExecutor<CrawlerTask> executor;
    private List<CrawlerTask> tasks = new Vector<>();
    @Override
    public void addTask(CrawlerTask task) {
        executor.execute(task);
        tasks.add(task);
    }

    @Override
    public void removeTask(long id) {
        Iterator<CrawlerTask> iterator = tasks.iterator();
        while (iterator.hasNext()){
            CrawlerTask task = iterator.next();
            if(task.getContext().getInfo().getId() == id){
                iterator.remove();
                break;
            }
        }
    }

    @Override
    public List<CrawlerTask> tasks() {
        return tasks;
    }
}
