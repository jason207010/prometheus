package com.web.controller;

import com.web.crawler.CrawlerTask;
import com.web.crawler.CrawlerTaskBuilder;
import com.web.crawler.DefaultCrawler;
import com.web.service.CrawlerTaskService;
import com.web.util.SpringFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class TestController {
    @Autowired
    private SpringFactory factory;
    @Autowired
    private CrawlerTaskService service;

    @RequestMapping("test")
    public String test(){
        CrawlerTaskBuilder builder = factory.create(CrawlerTaskBuilder.class);
        CrawlerTask task = builder
                .setAutoParse(true)
                .setResumable(false)
                .setCrawler(DefaultCrawler.class)
                .setDepth(10)
                .setTopN(999999)
                .setThreadNum(Runtime.getRuntime().availableProcessors() + 1)
                .setDesc("抓取CSDN博客的爬虫任务")
                .addSeed("http://blog.csdn.net")
                .addRegex("http://.*blog.csdn.net/.*/article/details/\\d+$")
                .build();
        service.addTask(task);
        return "test";
    }
    @RequestMapping("testStop")
    public String testStop(){
        List<CrawlerTask> tasks = service.tasks();
        for(CrawlerTask task : tasks){
            task.stop();
        }
        tasks.clear();
        return "test";
    }
    @RequestMapping("list")
    public String list(Model model){
        List<CrawlerTask> tasks = service.tasks();
        model.addAttribute("tasks" , tasks);
        return "list";
    }
}
