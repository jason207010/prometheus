package com.web.crawler;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author jayson   2015-07-10-15:13
 * @since v1.0
 */
@Component("IDGenerator")
public final class IDGenerator {
    private AtomicLong id = new AtomicLong(0L);

    public void update(long id){
        this.id.set(id);
    }

    public long generate(){
        return id.incrementAndGet();
    }
}