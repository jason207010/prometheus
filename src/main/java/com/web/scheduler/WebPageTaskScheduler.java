package com.web.scheduler;

import com.web.executor.webpage.WebPageTask;
import com.web.executor.webpage.WebPageTaskExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jayson  <br/> 2015-11-25 17:53
 * @since v1.0
 */
@Component("WebPageTaskScheduler")
public class WebPageTaskScheduler extends Scheduler<WebPageTask> {

    @Autowired
    private WebPageTaskExecutor executor;

    @Override
    protected void execute(WebPageTask product) {
        executor.execute(product);
    }

    @Override
    protected long getPollTimeMillis() {
        return 100L;
    }

    @Override
    protected long getSleepTimeMillis() {
        return 1000L;
    }
}
