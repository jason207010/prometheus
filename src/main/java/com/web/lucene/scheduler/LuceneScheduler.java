package com.web.lucene.scheduler;

import cn.edu.hfut.dmic.webcollector.model.Page;
import com.web.scheduler.Scheduler;
import com.web.service.LuceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jayson  <br/> 2015-11-17 15:47
 * @since v1.0
 */
@Component("LuceneScheduler")
public class LuceneScheduler extends Scheduler<Page> {

    @Autowired
    private LuceneService service;

    private ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);

    @Override
    protected void execute(Page product) {
        threadPool.execute(()->{
//            service.saveOrUpdate(product);
        });
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
