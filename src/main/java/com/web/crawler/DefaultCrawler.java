package com.web.crawler;

import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.model.Page;
import com.web.config.Config;
import com.web.executor.parser.ParseTask;
import com.web.parser.DefaultParser;
import com.web.scheduler.ParserTaskScheduler;
import com.web.util.SpringFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.util.regex.Pattern;

/**
 * @author jayson   2015-08-11 17:09
 * @since v1.0
 */
@Component("DefaultCrawler")
@Scope("prototype")
public class DefaultCrawler extends Crawler {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultCrawler.class);

    @Resource(name = "Config")
    private Config config;

    @Autowired
    private SpringFactory factory;

    @Autowired
    private ParserTaskScheduler scheduler;

    @Override
    public void visit(Page page, Links nextLinks) {
        for(Pattern p : patterns){
            if(p.matcher(page.getUrl()).matches()){
                try {
                    ParseTask task = factory.create(ParseTask.class);
                    DefaultParser parser = factory.create(DefaultParser.class);
                    task.setPage(page);
                    task.setParser(parser);
                    scheduler.schedule(task);
                } catch (InterruptedException e) {
                    LOGGER.error("" , e);
                }
                break;
            }
        }
    }

    @Override
    public String getCrawlPath() {
        return String.format("%s%s%s" , config.get("crawlerPath") , File.separator , crawlerInfo.getId());
    }
}
