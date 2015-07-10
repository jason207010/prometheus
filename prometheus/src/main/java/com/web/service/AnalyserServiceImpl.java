package com.web.service;

import cn.edu.hfut.dmic.webcollector.model.Page;
import com.web.analyser.AnalyseTask;
import com.web.analyser.Analyser;
import com.web.analyser.AnalyserPage;
import com.web.util.SpringFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author jayson   2015-07-10-15:46
 * @since v1.0
 */
@Service("AnalyserServiceImpl")
public class AnalyserServiceImpl implements AnalyserService , Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(AnalyserServiceImpl.class);
    private BlockingQueue<AnalyserPage> queue = new LinkedBlockingQueue<>();
    private ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);

    @Autowired
    private SpringFactory factory;

    @PostConstruct
    public void start(){
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true){
            AnalyserPage ap = null;
            try {
                ap = queue.take();
            } catch (InterruptedException e) {
                LOGGER.error("" , e);
            }
            if(ap == null){
                continue;
            }
            AnalyseTask task = factory.create(AnalyseTask.class);
            task.setAp(ap);
            pool.execute(task);
        }
    }

    @Override
    public void analyse(AnalyserPage ap) {
        try {
            queue.put(ap);
        } catch (InterruptedException e) {
            LOGGER.error("" , e);
        }
    }
}