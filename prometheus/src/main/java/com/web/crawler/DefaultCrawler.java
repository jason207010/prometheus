package com.web.crawler;

import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.model.Page;
import com.web.service.ParseService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author jayson   2015-08-11 17:09
 * @since v1.0
 */
@Component("DefaultCrawler")
@Scope("prototype")
public class DefaultCrawler extends Crawler {
    @Resource(name = "ParseServiceImpl")
    private ParseService service;
    @Override
    public void visit(Page page, Links nextLinks) {
        service.parse(page , DefaultCrawler.class);
    }
}
