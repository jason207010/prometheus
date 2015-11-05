package com.web.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author jayson   2015-07-10-17:36
 * @since v1.0
 */
@Component("SpringFactory")
public class SpringFactory implements ApplicationContextAware {
    public <T> T create(Class<T> clazz){
        T bean = applicationContext.getBean(clazz);
        return bean;
    }
    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
