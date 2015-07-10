package com.web.analyser;

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
@Component("AnalyserCrawlerRegister")
public class AnalyserCrawlerRegister implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    private Map<Class<Crawler> , Analyser> map = new ConcurrentHashMap<>();
    public <T extends Crawler> Analyser getAnalyser(Class<T> clazz){
        Analyser analyser = map.get(clazz);
        if(analyser != null){
            return analyser;
        }
        Map<String, Analyser> analysers = applicationContext.getBeansOfType(Analyser.class);
        for(Analyser a : analysers.values()){
            BindCrawler annotation = a.getClass().getAnnotation(BindCrawler.class);
            if(annotation.clazz() == clazz){
                analyser = a;
                break;
            }
        }
        if(analyser != null)
            map.putIfAbsent((Class<Crawler>) clazz, analyser);
        return analyser;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
