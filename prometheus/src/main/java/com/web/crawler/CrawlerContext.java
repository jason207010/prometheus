package com.web.crawler;

import cn.edu.hfut.dmic.webcollector.crawler.Crawler;

/**
 * @author jayson   2015-07-11-16:17
 * @since v1.0
 */
public abstract class CrawlerContext{
    protected Crawler crawler;
    protected CrawlerInfo info;

    public abstract void execute();
    public abstract void stop();
    public abstract CrawlerTaskStatus status();

    /**getter¡¢setter·½·¨**/
    public Crawler getCrawler() {
        return crawler;
    }

    public void setCrawler(Crawler crawler) {
        this.crawler = crawler;
    }

    public CrawlerInfo getInfo() {
        return info;
    }

    public void setInfo(CrawlerInfo info) {
        this.info = info;
    }
}