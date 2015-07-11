package com.web.crawlerr;

import com.web.builder.Builder;
import com.web.util.SpringFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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
    private CrawlerContext context;

    public CrawlerTaskBuilder setId(long id) {
        info.setId(id);
        return this;
    }

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

    public CrawlerTaskBuilder addRegex(String regex) {
        info.addRegex(regex);
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

    public CrawlerTaskBuilder setContext(CrawlerContext context){
        this.context = context;
        return this;
    }

    @Override
    public CrawlerTask build() {
        CrawlerTaskImpl task = factory.create(CrawlerTaskImpl.class);
        context.setCrawlerInfo(info);
        task.setContext(context);
        return task;
    }
}