package com.web.crawlerr;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author jayson   2015-07-11-15:53
 * @since v1.0
 */
@Component("CrawlerTaskImpl")
@Scope("prototype")
public class CrawlerTaskImpl implements CrawlerTask , Runnable {
    private CrawlerContext context;

    @Override
    public void start() {
    }

    @Override
    public void stop() {
    }

    @Override
    public CrawlerTaskStatus status() {
        return null;
    }

    @Override
    public void run() {
        start();
    }

    /**getter、setter方法**/
    public CrawlerContext getContext() {
        return context;
    }

    public void setContext(CrawlerContext context) {
        this.context = context;
    }
}