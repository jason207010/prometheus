package com.web.service;

import cn.edu.hfut.dmic.webcollector.crawler.Crawler;
import cn.edu.hfut.dmic.webcollector.model.Page;

/**
 * @author jayson   2015-07-12 16:59
 * @since v1.0
 */
public interface AnalyseService {
    public <T extends Crawler> void analyse(Page page , Class<T> clazz);
}
