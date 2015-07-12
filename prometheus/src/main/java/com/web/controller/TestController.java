package com.web.controller;

import com.web.crawler.CSDNBlogCrawler;
import com.web.crawler.CrawlerTask;
import com.web.crawler.CrawlerTaskBuilder;
import com.web.service.CrawlerTaskService;
import com.web.util.SpringFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TestController {
    @Autowired
    private SpringFactory factory;
    @Autowired
    private CrawlerTaskBuilder builder;
    @Autowired
    private CrawlerTaskService service;

    @RequestMapping("test")
    public String test(){
        CrawlerTask task = builder.setCrawlPath("")
                .setAutoParse(true)
                .setCrawler(CSDNBlogCrawler.class)
                .setDepth(5)
                .setDesc("抓取CSDN博客的爬虫任务")
                .setResumable(false)
                .setTopN(10)
                .build();
        service.addTask(task);
        return "test";
    }
}
