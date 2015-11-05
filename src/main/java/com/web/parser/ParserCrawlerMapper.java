package com.web.parser;

import cn.edu.hfut.dmic.webcollector.crawler.Crawler;
import com.web.annotation.BindCrawler;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jayson   2015-07-10-20:10
 * @since v1.0
 */
@Component("ParserCrawlerMapper")
public class ParserCrawlerMapper implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    private Map<Class<Crawler> , Parser> map = new ConcurrentHashMap<>();
    public <T extends Crawler> Parser getParser(Class<T> clazz){
        Parser parser = map.get(clazz);
        if(parser != null){
            return parser;
        }
        Map<String, Parser> parsers = applicationContext.getBeansOfType(Parser.class);
        for(Parser a : parsers.values()){
            BindCrawler annotation = a.getClass().getAnnotation(BindCrawler.class);
            if(annotation == null)
                continue;
            if(annotation.clazz() == clazz){
                parser = a;
                break;
            }
        }
        if(parser != null)
            map.putIfAbsent((Class<Crawler>) clazz, parser);
        return parser;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
