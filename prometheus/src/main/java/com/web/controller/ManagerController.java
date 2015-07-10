package com.web.controller;

import com.web.service.CrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jayson   2015-07-10-22:53
 * @since v1.0
 */
@Controller
@RequestMapping("/")
public class ManagerController {
    @Autowired
    private CrawlerService crawlerService;
    @RequestMapping("list")
    public String list(){
        return "list";
    }
}
