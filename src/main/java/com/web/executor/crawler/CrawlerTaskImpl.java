package com.web.executor.crawler;

import com.web.crawler.Crawler;
import com.web.crawler.CrawlerStatus;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author jayson   2015-08-11 17:42
 * @since v1.0
 */
@Component("CrawlerTaskImpl")
@Scope("prototype")
public class CrawlerTaskImpl implements CrawlerTask {
    private Crawler crawler;

    @Override
    public void stop() {
        crawler.stop();
    }

    @Override
    public CrawlerStatus getStatus() {
        return crawler.getStatus();
    }

    @Override
    public Crawler getCrawler() {
        return crawler;
    }

    @Override
    public void setCrawler(Crawler crawler) {
        this.crawler = crawler;
    }

    @Override
    public void execute() {
        crawler.start();
    }
}
