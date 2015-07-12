package com.web.controller;

import com.web.service.CrawlerService;
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

        return "test";
    }
}
