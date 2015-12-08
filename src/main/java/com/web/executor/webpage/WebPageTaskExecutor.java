package com.web.executor.webpage;

import com.web.executor.TaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jayson  <br/> 2015-11-25 17:45
 * @since v1.0
 */
@Component("WebPageTaskExecutor")
public class WebPageTaskExecutor implements TaskExecutor<WebPageTask> {


    private ExecutorService pool = Executors.newCachedThreadPool();

    @Override
    public void execute(WebPageTask task) {
        pool.execute(()->{
            task.execute();
        });
    }
}