package com.web.crawler;

import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.model.Page;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.web.config.Config;
import com.web.executor.parser.ParseTask;
import com.web.parser.CSDNBlogParser;
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
 * @author jayson   2015-08-13 17:04
 * @since v1.0
 */
@Component("CSDNBlogCrawler")
public class CSDNBlogCrawler extends Crawler {
    private static final Logger LOGGER = LoggerFactory.getLogger(CSDNBlogCrawler.class);

    @Autowired
    private ParserTaskScheduler scheduler;

    @Autowired
    private SpringFactory factory;

    @Autowired
    private Config config;

    @PostConstruct
    public void init() throws IOException {
        CrawlerInfo crawlerInfo = factory.create(CrawlerInfo.class);

        ClassPathResource resource = new ClassPathResource(config.get("CSDNBlogCrawler"));
        XStream xStream = new XStream(new StaxDriver());
        xStream.alias("CrawlerInfo" , CrawlerInfo.class);
        xStream.alias("String" , String.class);
        xStream.fromXML(resource.getFile() , crawlerInfo);

        setCrawlerInfo(crawlerInfo);
    }

    @Override
    public void visit(Page page, Links nextLinks) {
        String url = page.getUrl();

        for(Pattern p : patterns) {
            if (p.matcher(url).matches()) {
                try {
                    ParseTask task = factory.create(ParseTask.class);
                    CSDNBlogParser parser = factory.create(CSDNBlogParser.class);
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
