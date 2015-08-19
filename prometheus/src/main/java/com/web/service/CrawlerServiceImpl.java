package com.web.service;

import com.web.crawler.Crawler;
import com.web.crawler.CrawlerStore;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * @author jayson   2015-08-19 17:08
 * @since v1.0
 */
@Service("CrawlerServiceImpl")
public class CrawlerServiceImpl implements CrawlerService {
    @Resource(name = "CrawlerStore")
    private CrawlerStore store;
    @Override
    public Collection<Crawler> crawlers() {
        return store.crawlers();
    }

    @Override
    public Crawler get(long id) {
        return store.get(id);
    }
}
