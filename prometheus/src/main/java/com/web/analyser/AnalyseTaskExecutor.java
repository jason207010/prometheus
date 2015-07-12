package com.web.analyser;

import com.web.task.TaskExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author jayson   2015-07-12 17:26
 * @since v1.0
 */
@Component("AnalyseTaskExecutor")
public class AnalyseTaskExecutor implements TaskExecutor<AnalyseTask> , Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(AnalyseTaskExecutor.class);
    private BlockingQueue<AnalyseTask> tasks = new LinkedBlockingQueue<>();
    private ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);

    @PostConstruct
    public void init(){
        new Thread(this).start();
    }

    @Override
    public void execute(AnalyseTask task) {
        try {
            tasks.put(task);
        } catch (InterruptedException e) {
            LOGGER.error("" , e);
        }
    }

    @Override
    public void run() {
        while (true){
            AnalyseTask task = null;
            try {
                task = tasks.take();
            } catch (InterruptedException e) {
                LOGGER.error("" , e);
            }
            if(task != null)
                pool.execute(task);
        }
    }
}
