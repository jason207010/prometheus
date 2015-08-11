package com.web.crawler;

import com.web.entity.CrawlerInfoEntity;
import com.web.task.Task;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author jayson   2015-08-11 17:42
 * @since v1.0
 */
@Component("CrawlerTaskImpl")
@Scope("prototype")
public class CrawlerTaskImpl implements CrawlerTask , Task {
    private Crawler crawler;
    @Override
    public void stop() {
        crawler.stop();
    }

    @Override
    public CrawlerStatus getStatus() {
        return crawler.getCrawlerStatus();
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
