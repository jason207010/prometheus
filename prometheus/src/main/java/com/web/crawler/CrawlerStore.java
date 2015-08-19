package com.web.crawler;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/**
 * @author jayson   2015-08-19 15:06
 * @since v1.0
 */
@Component("CrawlerStore")
public class CrawlerStore implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    private Collection<Crawler> crawlers = Collections.EMPTY_LIST;

    public void init(){
        Map<String, Crawler> crawlerMap = applicationContext.getBeansOfType(Crawler.class, false, true);
        Collection<Crawler> crawlers = crawlerMap.values();
        this.crawlers = crawlers;
    }

    public Collection<Crawler> crawlers(){
        return this.crawlers;
    }

    public Crawler get(long id){
        Crawler crawler = null;
        for(Crawler c : crawlers){
            if(c.getCrawlerInfo().getId() == id){
                crawler = c;
                break;
            }
        }
        return crawler;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}