package com.web.crawler;

import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.model.Page;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.web.config.Config;
import com.web.executor.parser.ParseTask;
import com.web.parser.CNBlogsParser;
import com.web.scheduler.ParserTaskScheduler;
import com.web.util.SpringFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * @author jayson  <br/> 2016-01-25 14:48
 * @since v1.0
 */
@Component("CNBlogsCrawler")
public class CNBlogsCrawler extends Crawler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CNBlogsCrawler.class);


    @Autowired
    private Config config;

    @Autowired
    private SpringFactory factory;

    @Autowired
    private ParserTaskScheduler scheduler;

    @PostConstruct
    public void init() throws IOException {
        CrawlerInfo crawlerInfo = factory.create(CrawlerInfo.class);

        ClassPathResource resource = new ClassPathResource(config.get("CNBlogsCrawler"));
        XStream xStream = new XStream(new StaxDriver());
        xStream.alias("CrawlerInfo" , CrawlerInfo.class);
        xStream.alias("String" , String.class);
        xStream.fromXML(resource.getFile() , crawlerInfo);

        setCrawlerInfo(crawlerInfo);
    }

    @Override
    public String getCrawlPath() {
        return String.format("%s%s%s" , config.get("crawlerPath") , File.separator , crawlerInfo.getId());
    }

    @Override
    public void visit(Page page, Links links) {
        String url = page.getUrl();

        for(Pattern p : patterns) {
            if (p.matcher(url).matches()) {
                try {
                    ParseTask task = factory.create(ParseTask.class);
                    CNBlogsParser parser = factory.create(CNBlogsParser.class);
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
}
