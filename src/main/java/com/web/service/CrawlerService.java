package com.web.service;

import com.web.crawler.Crawler;

import java.util.Collection;

/**
 * @author jayson   2015-08-19 17:07
 * @since v1.0
 */
public interface CrawlerService {
    public Collection<Crawler> crawlers();
    public Crawler get(long id);
}
