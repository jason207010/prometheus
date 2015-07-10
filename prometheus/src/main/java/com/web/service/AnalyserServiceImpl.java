package com.web.service;

import cn.edu.hfut.dmic.webcollector.crawler.Crawler;
import cn.edu.hfut.dmic.webcollector.model.Page;
import com.web.analyser.Analyser;
import com.web.analyser.AnalyserCrawlerRegister;
import com.web.util.SpringFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jayson   2015-07-10-15:46
 * @since v1.0
 */
@Service("AnalyserServiceImpl")
public class AnalyserServiceImpl implements AnalyserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AnalyserServiceImpl.class);
    private ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
    @Autowired
    private AnalyserCrawlerRegister register;

    @Autowired
    private SpringFactory factory;

    @Override
    public <T extends Crawler> void analyse(Class<T> clazz, Page page) {
        Analyser analyser = register.getAnalyser(clazz);

    }
}