package com.web.controller;

import com.web.crawler.CrawlerTask;
import com.web.crawler.CrawlerTaskBuilder;
import com.web.crawler.DefaultCrawler;
import com.web.form.AddTaskForm;
import com.web.service.CrawlerService;
import com.web.util.SpringFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author jayson   2015-07-10-22:53
 * @since v1.0
 */
@Controller
@RequestMapping("/")
public class ManagerController {
    @Resource(name = "CrawlerServiceImpl")
    private CrawlerService crawlerService;
    @Resource(name = "SpringFactory")
    private SpringFactory factory;
    @RequestMapping("addTask")
    public String addTask(AddTaskForm form){
        CrawlerTaskBuilder builder = factory.create(CrawlerTaskBuilder.class);
        CrawlerTask task = builder.setDesc(form.getDesc())
                .setTopN(form.getTopN())
                .setAutoParse(form.isAutoParse())
                .setThreadNum(form.getThreadNum())
                .setResumable(form.isResumable())
                .setSeed(form.getSeed())
                .setRegex(form.getRegex())
                .setMaxRetry(form.getMaxRetry())
                .setRetry(form.getRetry())
                .setDepth(form.getDepth())
                .setCrawler(DefaultCrawler.class)
                .build();
        crawlerService.addTask(task);
        return "list";
    }
}