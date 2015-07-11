package com.web.crawlerr;

import cn.edu.hfut.dmic.webcollector.crawler.BreadthCrawler;
import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.model.Page;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author jayson   2015-07-11-17:33
 * @since v1.0
 */
@Component("CSDNBlogCrawler")
@Scope("prototype")
public class CSDNBlogCrawler extends BreadthCrawler {
    /**
     * @param crawlPath 维护URL信息的文件夹，如果爬虫需要断点爬取，每次请选择相同的crawlPath
     * @param autoParse 是否自动抽取符合正则的链接并加入后续任务
     */
    public CSDNBlogCrawler(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
    }
    public CSDNBlogCrawler(){
        this("" , true);
    }

    @Override
    public void visit(Page page, Links nextLinks) {

    }
}
