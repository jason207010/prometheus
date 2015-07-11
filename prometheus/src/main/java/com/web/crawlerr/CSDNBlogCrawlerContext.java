package com.web.crawlerr;

import cn.edu.hfut.dmic.webcollector.crawler.Crawler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author jayson   2015-07-11-17:20
 * @since v1.0
 */
@Component("CSDNBlogCrawlerContext")
@Scope("prototype")
public class CSDNBlogCrawlerContext implements CrawlerContext {
    private static final Logger LOGGER = LoggerFactory.getLogger(CSDNBlogCrawlerContext.class);
    private Crawler crawler;
    private CrawlerInfo info;
    @Override
    public void setCrawlerInfo(CrawlerInfo info) {
        this.info = info;
    }

    @Override
    public void start() {
        try {
            crawler.start(info.getDepth());
        } catch (Exception e) {
            LOGGER.error("" , e);
        }
    }

    @Override
    public void stop() {
        crawler.stop();
    }

    @Override
    public CrawlerTaskStatus status() {
        return crawler.getStatus() == Crawler.RUNNING ? CrawlerTaskStatus.Running : CrawlerTaskStatus.Stop;
    }
}
