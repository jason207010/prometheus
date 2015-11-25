package com.web.scheduler;

import com.web.executor.parser.ParseTask;
import com.web.executor.parser.ParseTaskExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jayson  <br/> 2015-11-17 16:29
 * @since v1.0
 */
@Component("ParserTaskScheduler")
public class ParserTaskScheduler extends Scheduler<ParseTask> {

    @Autowired
    private ParseTaskExecutor executor;

    @Override
    protected void execute(ParseTask product) {
        executor.execute(product);
    }

    @Override
    protected long getPollTimeMillis() {
        return 10;
    }

    @Override
    protected long getSleepTimeMillis() {
        return 1000;
    }
}
