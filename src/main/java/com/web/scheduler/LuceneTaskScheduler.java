package com.web.scheduler;

import com.web.executor.lucene.LuceneTask;
import com.web.executor.lucene.LuceneTaskExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jayson  <br/> 2015-11-25 18:03
 * @since v1.0
 */
@Component("LuceneTaskScheduler")
public class LuceneTaskScheduler extends Scheduler<LuceneTask> {

    @Autowired
    private LuceneTaskExecutor executor;

    @Override
    protected void execute(LuceneTask product) {
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
