package com.web.crawler;

import cn.edu.hfut.dmic.webcollector.crawler.BreadthCrawler;
import com.web.builder.Builder;
import com.web.util.Config;
import com.web.util.IDGenerator;
import com.web.util.SpringFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

/**
 * @author jayson   2015-07-11-16:25
 * @since v1.0
 */
@Component("CrawlerTaskBuilder")
@Scope("prototype")
public class CrawlerTaskBuilder implements Builder<CrawlerTask> {
    @Autowired
    private CrawlerInfo info;
    @Autowired
    private SpringFactory factory;
    @Autowired
    private IDGenerator generator;
    @Autowired
    private CrawlerContext context;
    @Autowired
    private Config config;

    private BreadthCrawler crawler;

    public CrawlerTaskBuilder setDesc(String desc) {
        info.setDesc(desc);
        return this;
    }

    public CrawlerTaskBuilder setTopN(int topN) {
        info.setTopN(topN);
        return this;
    }

    public CrawlerTaskBuilder setAutoParse(boolean autoParse) {
        info.setAutoParse(autoParse);
        return this;
    }

    public CrawlerTaskBuilder setCrawlPath(String crawlPath) {
        info.setCrawlPath(crawlPath);
        return this;
    }

    public CrawlerTaskBuilder setThreadNum(int threadNum) {
        info.setThreadNum(threadNum);
        return this;
    }

    public CrawlerTaskBuilder setResumable(boolean resumable) {
        info.setResumable(resumable);
        return this;
    }

    public CrawlerTaskBuilder addSeed(String seed) {
        info.addSeed(seed);
        return this;
    }

    public CrawlerTaskBuilder setSeed(List<String> seed){
        if(seed != null && !seed.isEmpty()){
            info.getSeed().addAll(seed);
        }
        return this;
    }

    public CrawlerTaskBuilder addRegex(String regex) {
        info.addRegex(regex);
        return this;
    }

    public CrawlerTaskBuilder setRegex(List<String> regex){
        if(regex != null && !regex.isEmpty()){
            info.getRegex().addAll(regex);
        }
        return this;
    }

    public CrawlerTaskBuilder setMaxRetry(int maxRetry) {
        info.setMaxRetry(maxRetry);
        return this;
    }

    public CrawlerTaskBuilder setRetry(int retry) {
        info.setRetry(retry);
        return this;
    }

    public CrawlerTaskBuilder setDepth(int depth) {
        info.setDepth(depth);
        return this;
    }

    public <T extends BreadthCrawler> CrawlerTaskBuilder setCrawler(Class<T> clazz){
        T crawler = factory.create(clazz);
        this.crawler = crawler;
        return this;
    }

    @Override
    public CrawlerTask build() {
        CrawlerTask task = factory.create(CrawlerTask.class);
        info.setId(generator.generate());
        info.setCrawlPath(config.get("crawlerPath") + File.separator + info.getId());
        context.setInfo(info);
        context.setCrawler(crawler);
        task.setContext(context);
        return task;
    }
}