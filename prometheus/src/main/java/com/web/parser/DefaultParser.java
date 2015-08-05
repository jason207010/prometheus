package com.web.parser;

import cn.edu.hfut.dmic.webcollector.model.Page;
import com.web.annotation.BindCrawler;
import com.web.crawler.DefaultCrawler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author jayson   2015-07-12 19:22
 * @since v1.0
 */
@Component("DefaultAnalyser")
@Scope("prototype")
@BindCrawler(clazz = DefaultCrawler.class)
public class DefaultParser implements Parser {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultParser.class);
    @Override
    public void analyse(Page page) {
        LOGGER.info("url:" + page.getUrl());
        LOGGER.info("title:" + page.getDoc().title());
    }
}
