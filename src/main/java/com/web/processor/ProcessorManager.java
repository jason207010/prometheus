package com.web.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;

/**
 * @author Jayson Chan<br/>2015-11-12 12:16
 * @since v1.0
 */
@Component
public class ProcessorManager implements ApplicationListener<ContextRefreshedEvent>, ApplicationContextAware {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessorManager.class);
    private ApplicationContext applicationContext;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if(contextRefreshedEvent.getApplicationContext().getParent() == null){
            afterStartup();
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void afterStartup(){
        Map<String, AfterStartupProcessor> map = applicationContext.getBeansOfType(AfterStartupProcessor.class);
        Collection<AfterStartupProcessor> processors = map.values();
        for(AfterStartupProcessor processor : processors){
            try {
                processor.afterStartup();
            } catch (Exception e) {
                LOGGER.error("" , e);
            }
        }
    }
}
