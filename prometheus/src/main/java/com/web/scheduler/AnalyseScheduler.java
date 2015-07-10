package com.web.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author jayson   2015-07-10-20:06
 * @since v1.0
 */
@Component("AnalyseScheduler")
public class AnalyseScheduler implements Scheduler , Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(AnalyseScheduler.class);
    private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
    private ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
    @PostConstruct
    public void start() {
        new Thread(this).start();
    }
    @Override
    public void schedule(Runnable task) {
        try {
            queue.put(task);
        } catch (InterruptedException e) {
            LOGGER.error("" , e);
        }
    }

    @Override
    public void run() {
        while (true) {
            Runnable task = null;
            try {
                task = queue.take();
            } catch (InterruptedException e) {
                LOGGER.error("", e);
            }
            if(task == null)
                continue;
            pool.execute(task);
        }
    }
}
