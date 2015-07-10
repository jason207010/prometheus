package com.web.crawler;

/**
 * @author jayson   2015-07-09-17:10
 * @since v1.0
 */

public interface CrawlerContext{
    public CrawlerContext setTopN(int topN);
    public CrawlerContext setAutoParse(boolean autoParse);
    public CrawlerContext setCrawlPath(String crawlPath);
    public CrawlerContext setThreads(int threadNum);
    public CrawlerContext setResumable(boolean resumable);
    public CrawlerContext addSeed(String seed);
    public CrawlerContext addRegex(String regex);
    public CrawlerContext setMaxRetry(int maxRetry);
    public CrawlerContext setRetry(int retry);
    public CrawlerContext setDepth(int depth);
    public void start();
    public void stop();
}
