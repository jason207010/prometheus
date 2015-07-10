package com.web.controller;

import com.web.task.CrawlerTask;
import com.web.task.CrawlerTaskFactory;
import com.web.task.DefaultCrawlerTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TestController {
    private CrawlerTaskFactory factory;
    @Autowired
    @RequestMapping("test")

    public String test(){
        CrawlerTask task = factory.get(DefaultCrawlerTask.class);

        return "test";
    }
}
