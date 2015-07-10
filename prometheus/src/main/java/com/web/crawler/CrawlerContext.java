package com.web.crawler;

/**
 * @author jayson   2015-07-09-17:10
 * @since v1.0
 */

public interface CrawlerContext{
    public abstract CrawlerContext setTopN(int topN);
    public abstract CrawlerContext setAutoParse(boolean autoParse);
    public abstract CrawlerContext setCrawlPath(String crawlPath);
    public abstract CrawlerContext setThreads(int threadNum);
    public abstract CrawlerContext setResumable(boolean resumable);
    public abstract CrawlerContext addSeed(String seed);
    public abstract CrawlerContext addRegex(String regex);
    public abstract CrawlerContext setMaxRetry(int maxRetry);
    public abstract CrawlerContext setRetry(int retry);
    public abstract CrawlerContext setDepth(int depth);
    public abstract void start();
}
