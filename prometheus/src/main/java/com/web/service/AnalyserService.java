package com.web.service;

import cn.edu.hfut.dmic.webcollector.crawler.Crawler;
import cn.edu.hfut.dmic.webcollector.model.Page;

/**
 * @author jayson   2015-07-10-15:44
 * @since v1.0
 */
public interface AnalyserService {
    public<T extends Crawler> void analyse(Class<T> clazz , Page page);
}
