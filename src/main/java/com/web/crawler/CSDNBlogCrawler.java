package com.web.crawler;

import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.model.Page;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.web.config.Config;
import com.web.entity.CrawlerInfoEntity;
import com.web.service.ParseService;
import com.web.util.SpringFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * @author jayson   2015-08-13 17:04
 * @since v1.0
 */
@Component("CSDNBlogCrawler")
public class CSDNBlogCrawler extends Crawler {
    @Resource(name = "ParseServiceImpl")
    private ParseService parseService;

    @Resource(name = "SpringFactory")
    private SpringFactory factory;

    @Autowired
    private Config config;

    @PostConstruct
    public void init() throws IOException {
        CrawlerInfoEntity crawlerInfo = factory.create(CrawlerInfoEntity.class);

        ClassPathResource resource = new ClassPathResource(config.get("CSDNBlogCrawler"));
        XStream xStream = new XStream(new StaxDriver());
        xStream.alias("CrawlerInfoEntity" , CrawlerInfoEntity.class);
        xStream.alias("String" , String.class);
        xStream.fromXML(resource.getFile() , crawlerInfo);

        setCrawlerInfo(crawlerInfo);
    }

    @Override
    public void visit(Page page, Links nextLinks) {
        String url = page.getUrl();

        for(Pattern p : patterns) {
            if (p.matcher(url).matches()) {
                parseService.parse(page, CSDNBlogCrawler.class);
                break;
            }
        }
    }

    @Override
    public String getCrawlPath() {
        return String.format("%s%s%s" , config.get("crawlerPath") , File.separator , getClass().getSimpleName());
    }
}
