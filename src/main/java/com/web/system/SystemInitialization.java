package com.web.system;

import com.web.processor.AfterStartupProcessor;
import com.web.scheduler.Scheduler;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jayson  <br/> 2015-11-27 17:09
 * @since v1.0
 */
@Component("SystemInitialization")
public class SystemInitialization implements AfterStartupProcessor , ApplicationContextAware {

    private ExecutorService pool = Executors.newCachedThreadPool();;

    private ApplicationContext applicationContext;

    @Override
    public void afterStartup() {
        Map<String, Scheduler> schedulerMap = applicationContext.getBeansOfType(Scheduler.class);
        for(Scheduler<?> scheduler : schedulerMap.values()){
            pool.execute(scheduler);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
