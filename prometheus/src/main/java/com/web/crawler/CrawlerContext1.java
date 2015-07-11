package com.web.crawler;

import cn.edu.hfut.dmic.webcollector.crawler.Crawler;
import com.web.crawlerr.CrawlerInfo;

/**
 * @author jayson   2015-07-11-15:03
 * @since v1.0
 */
public class CrawlerContext1 {
    private CrawlerInfo info;
    private Crawler crawler;
    public void start(){

    }

    public CrawlerInfo getInfo() {
        return info;
    }

    public void setInfo(CrawlerInfo info) {
        this.info = info;
    }
}