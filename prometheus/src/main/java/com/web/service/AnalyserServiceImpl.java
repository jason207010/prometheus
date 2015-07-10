package com.web.service;

import cn.edu.hfut.dmic.webcollector.crawler.Crawler;
import cn.edu.hfut.dmic.webcollector.model.Page;
import com.web.analyser.AnalyseTask;
import com.web.analyser.Analyser;
import com.web.analyser.AnalyserCrawlerRegister;
import com.web.scheduler.Scheduler;
import com.web.util.SpringFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jayson   2015-07-10-15:46
 * @since v1.0
 */
@Service("AnalyserServiceImpl")
public class AnalyserServiceImpl implements AnalyserService {
    @Autowired
    private AnalyserCrawlerRegister register;
    @Autowired
    private SpringFactory factory;
    @Resource(name = "AnalyseScheduler")
    private Scheduler scheduler;

    @Override
    public <T extends Crawler> void analyse(Class<T> clazz, Page page) {
        Analyser analyser = register.getAnalyser(clazz);
        AnalyseTask task = factory.create(AnalyseTask.class);
        task.setAnalyser(analyser);
        task.setPage(page);
        scheduler.schedule(task);
    }
}