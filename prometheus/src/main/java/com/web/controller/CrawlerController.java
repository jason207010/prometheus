package com.web.controller;

import com.web.crawler.CrawlerTask;
import com.web.crawler.CrawlerTaskBuilder;
import com.web.crawler.DefaultCrawler;
import com.web.form.AddTaskForm;
import com.web.service.CrawlerTaskService;
import com.web.util.ConverseUtil;
import com.web.util.SpringFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jayson   2015-07-10-22:53
 * @since v1.0
 */
@Controller
@RequestMapping("/crawler")
public class CrawlerController {
    @Autowired
    private CrawlerTaskService service;
    @Resource(name = "SpringFactory")
    private SpringFactory factory;
    @Resource(name = "ConverseUtil")
    private ConverseUtil util;

    @RequestMapping("/addInit")
    public String addInit(){
        return "crawler/add";
    }
    @RequestMapping("/add")
    public String add(@ModelAttribute AddTaskForm form , Model model){
        CrawlerTaskBuilder builder = factory.create(CrawlerTaskBuilder.class);
        CrawlerTask task = builder.setDesc(form.getDesc())
                .setTopN(util.converse(form.getTopN()))
                .setAutoParse(util.converse(form.getAutoParse()))
                .setThreadNum(util.converse(form.getThreadNum()))
                .setResumable(util.converse(form.getResumable()))
                .setSeed(form.getSeed())
                .setRegex(form.getRegex())
                .setMaxRetry(util.converse(form.getMaxRetry()))
                .setRetry(util.converse(form.getRetry()))
                .setDepth(util.converse(form.getDepth()))
                .setCrawler(DefaultCrawler.class)
                .build();
        service.addTask(task);
        model.addAttribute("msg" , "添加爬虫任务成功！");
        return "redirect:list.do";
    }
    @RequestMapping("/list")
    public String list(Model model){
        List<CrawlerTask> tasks = service.tasks();
        model.addAttribute("tasks", tasks);
        return "crawler/list";
    }
    @RequestMapping("/remove")
    public String remove(@RequestParam(required = true) long id , Model model){
        service.removeTask(id);
        model.addAttribute("msg" , "删除爬虫任务成功！");
        return "redirect:list.do";
    }
}