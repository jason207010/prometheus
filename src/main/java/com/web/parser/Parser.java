package com.web.parser;

import cn.edu.hfut.dmic.webcollector.model.Page;
import com.web.crawler.Crawler;

/**
 * @author jayson   2015-07-10-15:49
 * @since v1.0
 */
public interface Parser<T extends Crawler> {
    public void parse(Page page);

    public Class<T> getBindCrawler();
}
