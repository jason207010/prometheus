package com.web.service;

import cn.edu.hfut.dmic.webcollector.model.Page;
import com.web.crawler.Crawler;
import com.web.parser.Parser;
import com.web.parser.ParserCrawlerMapper;
import com.web.parser.task.ParseTask;
import com.web.parser.task.ParseTaskImpl;
import com.web.task.TaskExecutor;
import com.web.util.SpringFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author jayson   2015-07-12 17:01
 * @since v1.0
 */
@Component("ParseServiceImpl")
public class ParseServiceImpl implements ParseService {

    @Autowired
    private ParserCrawlerMapper register;

    @Autowired
    private SpringFactory factory;

    @Resource(name = "ParseTaskExecutor")
    private TaskExecutor<ParseTask> executor;

    @Override
    public <T extends Crawler> void parse(Page page, Class<T> clazz) {
        Parser parser = register.getParser(clazz);
        ParseTask task = factory.create(ParseTaskImpl.class);
        task.setParser(parser);
        task.setPage(page);
        executor.execute(task);
    }
}
