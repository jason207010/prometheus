package com.web.service;

import com.web.crawler.Crawler;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author jayson   2015-08-19 17:08
 * @since v1.0
 */
@Service("CrawlerServiceImpl")
public class CrawlerServiceImpl implements CrawlerService , ApplicationContextAware {
    private ApplicationContext context;

    private Map<Long , Crawler> crawlers = new HashMap<>();

    @PostConstruct
    public void init(){
        Map<String, Crawler> crawlerMap = context.getBeansOfType(Crawler.class, false, true);
        for(Entry<String , Crawler> e : crawlerMap.entrySet()){
            crawlers.put(e.getValue().getCrawlerInfo().getId() , e.getValue());
        }
    }

    @Override
    public Collection<Crawler> crawlers() {
        return crawlers.values();
    }

    @Override
    public Crawler get(long id) {
        return crawlers.get(id);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
