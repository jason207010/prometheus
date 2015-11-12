package com.web.parser;

import cn.edu.hfut.dmic.webcollector.model.Page;
import com.web.crawler.DefaultCrawler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author jayson   2015-07-12 19:22
 * @since v1.0
 */
@Component("DefaultParser")
public class DefaultParser implements Parser<DefaultCrawler> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultParser.class);

    @Override
    public Class<DefaultCrawler> getBindCrawler() {
        return DefaultCrawler.class;
    }

    @Override
    public void parse(Page page) {
        LOGGER.info("url:" + page.getUrl());
        LOGGER.info("title:" + page.getDoc().title());
    }
}
