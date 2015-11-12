package com.web.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;

/**
 * @author Jayson Chan<br/>2015-11-12 12:16
 * @since v1.0
 */
@Component
public class ProcessorManager implements BeanFactoryPostProcessor , ApplicationContextAware {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessorManager.class);
    private ApplicationContext applicationContext;
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        afterStartup();
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
