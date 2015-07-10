package com.web.task;

import com.web.crawler.CrawlerContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author jayson   2015-07-09-21:36
 * @since v1.0
 */
@Component("DefaultCrawlerTask")
@Scope("prototype")
public class DefaultCrawlerTask extends CrawlerTask {
    @Resource(name = "DefaultCrawlerContext")
    private CrawlerContext context;

    @Override
    public void before() {

    }

    @Override
    public void after() {

    }

    @Override
    public CrawlerContext setTopN(int topN) {
        context.setTopN(topN);
        return this;
    }

    @Override
    public CrawlerContext setAutoParse(boolean autoParse) {
        context.setAutoParse(autoParse);
        return this;
    }

    @Override
    public CrawlerContext setCrawlPath(String crawlPath) {
        context.setCrawlPath(crawlPath);
        return this;
    }

    @Override
    public CrawlerContext setThreads(int threadNum) {
        context.setThreads(threadNum);
        return this;
    }

    @Override
    public CrawlerContext setResumable(boolean resumable) {
        context.setResumable(resumable);
        return this;
    }

    @Override
    public CrawlerContext addSeed(String seed) {
        context.addSeed(seed);
        return this;
    }

    @Override
    public CrawlerContext addRegex(String regex) {
        context.addRegex(regex);
        return this;
    }

    @Override
    public CrawlerContext setMaxRetry(int maxRetry) {
        context.setMaxRetry(maxRetry);
        return this;
    }

    @Override
    public CrawlerContext setRetry(int retry) {
        context.setRetry(retry);
        return this;
    }

    @Override
    public CrawlerContext setDepth(int depth) {
        context.setDepth(depth);
        return this;
    }

    @Override
    public void start() {
        context.start();
    }

    @Override
    public void stop() {
        context.stop();
    }
}
