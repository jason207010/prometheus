package com.web.crawler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author jayson   2015-07-09-22:42
 * @since v1.0
 */
@Component("DefaultCrawlerContext")
@Scope("prototype")
public class DefaultCrawlerContext implements CrawlerContext {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultCrawlerContext.class);
    @Autowired
    private DefaultCrawler crawler;
    private int depth = 0;

    @Override
    public CrawlerContext setTopN(int topN) {
        crawler.setTopN(topN);
        return this;
    }

    @Override
    public CrawlerContext setAutoParse(boolean autoParse) {
        crawler.setAutoParse(autoParse);
        return this;
    }

    @Override
    public CrawlerContext setCrawlPath(String crawlPath) {
        crawler.setCrawlPath(crawlPath);
        return this;
    }

    @Override
    public CrawlerContext setThreads(int threadNum) {
        crawler.setThreads(threadNum);
        return this;
    }

    @Override
    public CrawlerContext setResumable(boolean resumable) {
        crawler.setResumable(resumable);
        return this;
    }

    @Override
    public CrawlerContext addSeed(String seed) {
        crawler.addSeed(seed);
        return this;
    }

    @Override
    public CrawlerContext addRegex(String regex) {
        crawler.addRegex(regex);
        return this;
    }

    @Override
    public CrawlerContext setMaxRetry(int maxRetry) {
        crawler.setMaxRetry(maxRetry);
        return this;
    }

    @Override
    public CrawlerContext setRetry(int retry) {
        crawler.setRetry(retry);
        return this;
    }

    @Override
    public CrawlerContext setDepth(int depth) {
        this.depth = depth;
        return this;
    }

    @Override
    public void start(){
        try {
            crawler.start(depth);
        } catch (Exception e) {
            LOGGER.error("" , e);
        }
    }

    @Override
    public void stop() {
        crawler.stop();
    }
}
