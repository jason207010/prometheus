package com.web.controller;

import com.web.service.CrawlerService;
import com.web.crawler.CrawlerTask;
import com.web.crawler.DefaultCrawlerTask;
import com.web.util.IDGenerator;
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
    private CrawlerService service;
    @Autowired
    private IDGenerator generator;

    @RequestMapping("test")

    public String test(){
        CrawlerTask task = factory.create(DefaultCrawlerTask.class);
        task.setId(generator.generate())
                .setDesc("DefaultCrawlerTask")
                .setDepth(5)
                .setAutoParse(true)
                .setThreads(5)
                .setTopN(100)
                .setResumable(false)
                .setCrawlPath("E:\\data")
                .addSeed("http://blog.csdn.net")
                .addRegex("http://.*blog.csdn.net/.*/article/details/\\d+$");
        service.addTask(task);
        return "test";
    }
}
