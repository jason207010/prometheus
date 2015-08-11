package com.web.parser;

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
@Component("ParseTaskExecutor")
public class ParseTaskExecutor implements TaskExecutor<ParseTask> , Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(ParseTaskExecutor.class);
    private BlockingQueue<ParseTask> tasks = new LinkedBlockingQueue<>();
    private ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);

    @PostConstruct
    public void init(){
        new Thread(this).start();
    }

    @Override
    public void execute(ParseTask task) {
        try {
            tasks.put(task);
        } catch (InterruptedException e) {
            LOGGER.error("" , e);
        }
    }

    @Override
    public void run() {
        while (true){
            try {
                ParseTask task = tasks.take();
                if(task != null) {
                    pool.execute(() ->{
                        task.execute();
                    });
                }
            } catch (InterruptedException e) {
                LOGGER.error("" , e);
            }
        }
    }
}
