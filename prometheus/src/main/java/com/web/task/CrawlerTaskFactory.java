package com.web.task;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author jayson   2015-07-09-21:32
 * @since v1.0
 */
@Component("CrawlerTaskFactory")
public class CrawlerTaskFactory implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    public <T extends CrawlerTask> T get(Class<T> clazz){
        T bean = applicationContext.getBean(clazz);
        return bean;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
