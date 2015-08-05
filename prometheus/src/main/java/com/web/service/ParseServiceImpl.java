package com.web.service;

import cn.edu.hfut.dmic.webcollector.crawler.Crawler;
import cn.edu.hfut.dmic.webcollector.model.Page;
import com.web.parser.ParseTask;
import com.web.parser.Parser;
import com.web.parser.ParserCrawlerRegister;
import com.web.task.TaskExecutor;
import com.web.util.SpringFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author jayson   2015-07-12 17:01
 * @since v1.0
 */
@Component("AnalyseManagerImpl")
public class ParseServiceImpl implements ParseService {
    @Autowired
    private ParserCrawlerRegister register;
    @Autowired
    private SpringFactory factory;
    @Resource(name = "AnalyseTaskExecutor")
    private TaskExecutor<ParseTask> executor;

    @Override
    public <T extends Crawler> void analyse(Page page, Class<T> clazz) {
        Parser analyser = register.getAnalyser(clazz);
        ParseTask task = factory.create(ParseTask.class);
        task.setAnalyser(analyser);
        task.setPage(page);
        executor.execute(task);
    }
}
