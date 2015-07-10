package com.web.crawler;

import cn.edu.hfut.dmic.webcollector.crawler.BreadthCrawler;
import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.model.Page;
import com.web.service.AnalyserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author jayson   2015-07-09-12:17
 * @since v1.0
 */
@Component("DefaultCrawler")
@Scope("prototype")
public class DefaultCrawler extends BreadthCrawler {
    @Autowired
    private AnalyserService service;

    /**
     * @param crawlPath 维护URL信息的文件夹，如果爬虫需要断点爬取，每次请选择相同的crawlPath
     * @param autoParse 是否自动抽取符合正则的链接并加入后续任务
     */
    private DefaultCrawler(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
    }

    public DefaultCrawler(){
        this(null, true);
    }

    @Override
    public void visit(Page page, Links nextLinks) {
        service.analyse(DefaultCrawler.class , page);
    }

    @Override
    public void start(int depth) throws Exception {
        super.start(depth);
    }
}
