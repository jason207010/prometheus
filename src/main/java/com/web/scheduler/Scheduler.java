package com.web.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author jayson  <br/> 2015-11-17 14:50
 * @since v1.0
 * 基于阻塞队列的生产者-消费者模式调度器，相当于流水线
 */
public abstract class Scheduler<T> implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(Scheduler.class);

    protected BlockingQueue<T> queue = new LinkedBlockingQueue<>();

    @Override
    public void run() {
        while (true){
            try {
                T product = queue.poll(getPollTimeMillis(), TimeUnit.MILLISECONDS);
                if(product == null){
                    Thread.sleep(getSleepTimeMillis());//没有事情可做，先休眠一段时间，把CPU资源让给其他线程
                    continue;
                }
                execute(product);
            } catch (InterruptedException e) {
                LOGGER.error("" , e);
            }
        }
    }

    /**
     * 添加产品到流水线上
     * @param product
     * @throws InterruptedException
     */
    public void schedule(T product) throws InterruptedException {
        queue.put(product);
    }

    protected abstract void execute(T product);

    protected abstract long getPollTimeMillis();
    protected abstract long getSleepTimeMillis();
}
