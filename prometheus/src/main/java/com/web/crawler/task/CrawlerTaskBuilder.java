package com.web.crawler.task;

import com.web.crawler.Crawler;
import com.web.entity.CrawlerInfoEntity;
import com.web.util.SpringFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author jayson   2015-08-11 21:18
 * @since v1.0
 */
@Component("CrawlerTaskBuilder")
@Scope("prototype")
public class CrawlerTaskBuilder {
    @Resource(name = "SpringFactory")
    private SpringFactory factory;
    @Resource(name = "CrawlerInfoEntity")
    private CrawlerInfoEntity crawlerInfo;

    private Crawler crawler;

    public CrawlerTaskBuilder setDesc(String desc) {
        crawlerInfo.setDesc(desc);
        return this;
    }

    public CrawlerTaskBuilder setTopN(int topN) {
        crawlerInfo.setTopN(topN);
        return this;
    }

    public CrawlerTaskBuilder setAutoParse(boolean autoParse) {
        crawlerInfo.setAutoParse(autoParse);
        return this;
    }

    public CrawlerTaskBuilder setThreadNum(int threadNum) {
        crawlerInfo.setThreadNum(threadNum);
        return this;
    }

    public CrawlerTaskBuilder setResumable(boolean resumable) {
        crawlerInfo.setResumable(resumable);
        return this;
    }

    public CrawlerTaskBuilder setSeeds(String seeds) {
        crawlerInfo.setSeeds(seeds);
        return this;
    }

    public CrawlerTaskBuilder setRegex(String regex) {
        crawlerInfo.setRegex(regex);
        return this;
    }

    public CrawlerTaskBuilder setMaxRetry(int maxRetry) {
        crawlerInfo.setMaxRetry(maxRetry);
        return this;
    }

    public CrawlerTaskBuilder setRetry(int retry) {
        crawlerInfo.setRetry(retry);
        return this;
    }

    public CrawlerTaskBuilder setDepth(int depth) {
        crawlerInfo.setDepth(depth);
        return this;
    }

    public <T extends Crawler> CrawlerTaskBuilder setCrawler(Class<T> crawler) {
        T instance = factory.create(crawler);
        this.crawler = instance;
        return this;
    }

    public CrawlerTask build(){
        CrawlerTask crawlerTask = factory.create(CrawlerTaskImpl.class);
        CrawlerInfoEntity crawlerInfo = factory.create(CrawlerInfoEntity.class);
        crawler.setCrawlerInfo(crawlerInfo);
        crawlerTask.setCrawler(crawler);
        return crawlerTask;
    }
}
