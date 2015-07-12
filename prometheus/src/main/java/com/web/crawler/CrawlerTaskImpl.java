package com.web.crawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author jayson   2015-07-11-15:53
 * @since v1.0
 */
@Component("CrawlerTaskImpl")
@Scope("prototype")
public class CrawlerTaskImpl extends CrawlerTask {
    @Autowired
    private CrawlerContext context;


    @Override
    public void stop() {
        context.stop();
    }

    @Override
    public CrawlerTaskStatus status() {
        return context.status();
    }

    @Override
    public void execute() {
        context.execute();
    }

    /**getter、setter方法**/
    public CrawlerContext getContext() {
        return context;
    }

    public void setContext(CrawlerContext context) {
        this.context = context;
    }
}