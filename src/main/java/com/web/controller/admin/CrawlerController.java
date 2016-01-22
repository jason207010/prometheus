package com.web.controller.admin;

import com.web.crawler.Crawler;
import com.web.crawler.CrawlerStatus;
import com.web.executor.crawler.CrawlerTask;
import com.web.form.AddTaskForm;
import com.web.service.CrawlerService;
import com.web.service.CrawlerTaskService;
import com.web.util.SpringFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @author jayson   2015-07-10-22:53
 * @since v1.0
 */
@Controller
@RequestMapping("/admin/crawler")
public class CrawlerController {
    @Autowired
    private CrawlerTaskService crawlerTaskService;

    @Autowired
    private SpringFactory factory;

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
    public String add(@RequestParam long id){
        Crawler crawler = crawlerService.get(id);
        if(crawler == null)
            return "redirect:404.jsp";

        if(crawler.getStatus() == CrawlerStatus.Running)
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