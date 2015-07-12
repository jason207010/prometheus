package com.web.crawler;

import cn.edu.hfut.dmic.webcollector.crawler.Crawler;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author jayson   2015-07-11-17:20
 * @since v1.0
 */
@Component("CrawlerContextImpl")
@Scope("prototype")
public class CrawlerContextImpl extends CrawlerContext {
    private static final Logger LOGGER = LoggerFactory.getLogger(CrawlerContextImpl.class);

    @Override
    public void execute() {
        try {
            if(info.getTopN() > 0)
                crawler.setTopN(info.getTopN());
            if(StringUtils.isNotBlank(info.getCrawlPath()))
                crawler.setCrawlPath(info.getCrawlPath());
            if(info.getMaxRetry() > 0)
                crawler.setMaxRetry(info.getMaxRetry());
            if(info.getRegex().isEmpty()){
                for(String regex : info.getRegex()){
                }
            }

            crawler.start(info.getDepth());
        } catch (Exception e) {
            LOGGER.error("" , e);
        }
    }

    @Override
    public void stop() {
        crawler.stop();
    }

    @Override
    public CrawlerTaskStatus status() {
        return crawler.getStatus() == Crawler.RUNNING ? CrawlerTaskStatus.Running : CrawlerTaskStatus.Stop;
    }
}
