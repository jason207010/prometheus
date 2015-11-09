package com.web.crawler.task;

import com.web.builder.Builder;
import com.web.crawler.Crawler;
import com.web.crawler.CrawlerStatus;
import com.web.entity.CrawlerInfoEntity;
import com.web.util.SpringFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jayson   2015-08-11 17:42
 * @since v1.0
 */
@Component("CrawlerTaskImpl")
@Scope("prototype")
public class CrawlerTaskImpl implements CrawlerTask {
    private Crawler crawler;

    private CrawlerTaskImpl(){}

    @Override
    public void stop() {
        crawler.stop();
    }

    @Override
    public CrawlerStatus getStatus() {
        return crawler.getStatus();
    }

    @Override
    public Crawler getCrawler() {
        return crawler;
    }

    @Override
    public void setCrawler(Crawler crawler) {
        this.crawler = crawler;
    }

    @Override
    public void execute() {
        crawler.start();
    }



    @Component("CrawlerTaskBuilder")
    @Scope("prototype")
    public static class CrawlerTaskBuilder implements Builder<CrawlerTask>{
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

        public CrawlerTaskBuilder setResumable(boolean resumable) {
            crawlerInfo.setResumable(resumable);
            return this;
        }

        public CrawlerTaskBuilder setSeeds(List<String> seeds) {
            crawlerInfo.setSeeds(seeds);
            return this;
        }

        public CrawlerTaskBuilder setRegex(List<String> regex) {
            crawlerInfo.setRegex(regex);
            return this;
        }

        public CrawlerTaskBuilder setMatching(List<String> matching){
            crawlerInfo.setMatching(matching);
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
        @Override
        public CrawlerTask build() {
            CrawlerTask crawlerTask = factory.create(CrawlerTaskImpl.class);
            crawler.setCrawlerInfo(crawlerInfo);
            crawlerTask.setCrawler(crawler);
            return crawlerTask;
        }
    }
}
