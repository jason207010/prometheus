package com.web.crawler;

import cn.edu.hfut.dmic.webcollector.crawler.BreadthCrawler;
import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.model.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;
@Component
public class CSDNBlogCrawler extends BreadthCrawler {
    private AtomicLong count = new AtomicLong(0);
    private static final Logger LOGGER = LoggerFactory.getLogger(CSDNBlogCrawler.class);
    /**
     * @param crawlPath 维护URL信息的文件夹，如果爬虫需要断点爬取，每次请选择相同的crawlPath
     * @param autoParse 是否自动抽取符合正则的链接并加入后续任务
     */
    public CSDNBlogCrawler(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
        this.addRegex("http://.*blog.csdn.net/.*/article/details/\\d+$");
        this.addSeed("http://blog.csdn.net");
    }
    public CSDNBlogCrawler(){
        this("E:\\data", true);
    }
    @Override
    public void visit(Page page, Links nextLinks) {
        count.incrementAndGet();
        LOGGER.info(page.getUrl());
        LOGGER.info(page.getDoc().title());
        LOGGER.info("已爬取博客" + count.get() + "篇");
    }
}