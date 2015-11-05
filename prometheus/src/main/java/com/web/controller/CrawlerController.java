package com.web.controller;

import com.web.crawler.*;
import com.web.crawler.task.CrawlerTask;
import com.web.crawler.task.CrawlerTaskBuilder;
import com.web.form.AddTaskForm;
import com.web.service.CrawlerService;
import com.web.service.CrawlerTaskService;
import com.web.util.ConverseUtil;
import com.web.util.SpringFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * @author jayson   2015-07-10-22:53
 * @since v1.0
 */
@Controller
@RequestMapping("/crawler")
public class CrawlerController {
    @Autowired
    private CrawlerTaskService crawlerTaskService;
    @Resource(name = "SpringFactory")
    private SpringFactory factory;
    @Resource(name = "ConverseUtil")
    private ConverseUtil util;
    @Resource(name = "CrawlerServiceImpl")
    private CrawlerService crawlerService;

    @RequestMapping("/addInit")
    public String addInit(AddTaskForm form , Model model){
        model.addAttribute("form", form);
        Collection<Crawler> crawlers = crawlerService.crawlers();
        model.addAttribute("crawlers" , crawlers);
        return "crawler/add";
    }
    @RequestMapping("/add")
    public String add(@Valid AddTaskForm form , BindingResult result , Model model){
        if(result.hasErrors())
            return "crawler/add";

        CrawlerTaskBuilder builder = factory.create(CrawlerTaskBuilder.class);
        CrawlerTask task = builder.setDesc(form.getDesc())
                .setTopN(util.converse(form.getTopN()))
                .setAutoParse(util.converse(form.getAutoParse()))
                .setThreadNum(util.converse(form.getThreadNum()))
                .setResumable(util.converse(form.getResumable()))
                .setSeeds(form.getSeeds())
                .setRegex(form.getRegex())
                .setMaxRetry(util.converse(form.getMaxRetry()))
                .setRetry(util.converse(form.getRetry()))
                .setDepth(util.converse(form.getDepth()))
                .setCrawler(DefaultCrawler.class)
                .build();
        crawlerTaskService.addTask(task);

        model.addAttribute("msg" , "添加爬虫任务成功！");
        return "redirect:list.do";
    }
    @RequestMapping("/addBuildIn")
    public String addBuildIn(@RequestParam long id){
        Crawler crawler = crawlerService.get(id);
        if(crawler == null)
            return "redirect:404.jsp";

        if(crawler.getCrawlerStatus() == CrawlerStatus.Running)
            return "redirect:404.jsp";

        CrawlerTask task = factory.create(CrawlerTask.class);
        task.setCrawler(crawler);
        crawlerTaskService.addTask(task);
        return "redirect:list.do";
    }

    @RequestMapping("/list")
    public String list(Model model){
        List<CrawlerTask> tasks = crawlerTaskService.tasks();
        model.addAttribute("tasks", tasks);
        return "crawler/list";
    }
    @RequestMapping("/remove")
    public String remove(@RequestParam(required = true) long id , Model model){
        crawlerTaskService.removeTask(id);
        model.addAttribute("msg" , "删除爬虫任务成功！");
        return "redirect:list.do";
    }
}