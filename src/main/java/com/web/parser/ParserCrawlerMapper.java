package com.web.parser;

import com.web.crawler.Crawler;
import com.web.processor.AfterStartupProcessor;
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
public class ParserCrawlerMapper implements ApplicationContextAware , AfterStartupProcessor {

    private ApplicationContext applicationContext;

    private Map<Class<Crawler> , Parser> map = new ConcurrentHashMap<>();

    @Override
    public void afterStartup() {
        Map<String, Parser> parserMap = applicationContext.getBeansOfType(Parser.class);
        for(Parser p : parserMap.values()){
            map.put(p.getBindCrawler() , p);
        }
    }

    public <T extends Crawler> Parser getParser(Class<T> clazz){
        return map.get(clazz);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
