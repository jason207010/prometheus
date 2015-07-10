package com.web.controller;

import com.web.service.CrawlerService;
import com.web.task.CrawlerTask;
import com.web.task.CrawlerTaskFactory;
import com.web.task.DefaultCrawlerTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TestController {
    @Autowired
    private CrawlerTaskFactory factory;
    @Autowired
    private CrawlerService service;

    @Autowired
    @RequestMapping("test")

    public String test(){
        CrawlerTask task = factory.get(DefaultCrawlerTask.class);
        service.addTask(task);
        return "test";
    }
}
