package com.web.crawler;

import cn.edu.hfut.dmic.webcollector.crawler.BreadthCrawler;
import com.web.entity.CrawlerInfoEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author jayson   2015-08-11 16:34
 * @since v1.0
 */
public abstract class Crawler extends BreadthCrawler {
    private static final Logger LOGGER = LoggerFactory.getLogger(Crawler.class);
    protected CrawlerInfoEntity crawlerInfo;
    protected List<Pattern> patterns = new ArrayList<>();

    /**
     * @param crawlPath 维护URL信息的文件夹，如果爬虫需要断点爬取，每次请选择相同的crawlPath
     * @param autoParse 是否自动抽取符合正则的链接并加入后续任务
     */
    public Crawler(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
    }
    public Crawler() {
        this(null, true);
    }

    public void start(){
        try {
            boolean resumable = crawlerInfo.isResumable();

            File file = new File(getCrawlPath());
            if(!file.exists()){
                file.mkdirs();

                if(resumable)
                    resumable = false;
            }

            for(String seed : crawlerInfo.getSeeds())
                addSeed(seed);

            for(String regex : crawlerInfo.getRegex())
                addRegex(regex);

            setTopN(crawlerInfo.getTopN());
            setAutoParse(crawlerInfo.isAutoParse());

            Class<?> clazz = this.getClass();
            Class<?> superClazz = null;
            while (true){
                superClazz = clazz.getSuperclass();
                if(superClazz == cn.edu.hfut.dmic.webcollector.crawler.Crawler.class){
                    break;
                }
                clazz = superClazz;
            }
            Field field = superClazz.getDeclaredField("crawlPath");
            field.setAccessible(true);
            field.set(this, getCrawlPath());

            setThreads(Runtime.getRuntime().availableProcessors());
            setResumable(resumable);
            setMaxRetry(crawlerInfo.getMaxRetry());
            setRetry(crawlerInfo.getRetry());

            for(String m : crawlerInfo.getMatching()){
                patterns.add(Pattern.compile(m));
            }

            super.start(crawlerInfo.getDepth());

        } catch (Exception e) {
            LOGGER.error("" , e);
        }
    }

    public CrawlerStatus getStatus(){
        return status == RUNNING ? CrawlerStatus.Running : CrawlerStatus.Stop;
    }

    public abstract String getCrawlPath();

    /**getter、setter方法**/
    public CrawlerInfoEntity getCrawlerInfo() {
        return crawlerInfo;
    }

    public void setCrawlerInfo(CrawlerInfoEntity crawlerInfo) {
        this.crawlerInfo = crawlerInfo;
    }
}