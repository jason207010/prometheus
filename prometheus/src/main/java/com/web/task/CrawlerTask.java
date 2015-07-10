package com.web.task;

import com.web.crawler.CrawlerContext;

/**
 * @author jayson   2015-07-09-12:13
 * @since v1.0
 */
public abstract class CrawlerTask implements Runnable , CrawlerContext {
    private long id;
    private String desc;
    public abstract void before();
    public abstract void after();

    @Override
    public void run() {
        before();
        start();
        after();
    }

    /**getter、setter方法**/
    public long getId() {
        return id;
    }

    public CrawlerTask setId(long id) {
        this.id = id;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public CrawlerTask setDesc(String desc) {
        this.desc = desc;
        return this;
    }
}
