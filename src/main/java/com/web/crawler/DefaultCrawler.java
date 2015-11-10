package com.web.crawler;

import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.model.Page;
import com.web.config.Config;
import com.web.service.ParseService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.util.regex.Pattern;

/**
 * @author jayson   2015-08-11 17:09
 * @since v1.0
 */
@Component("DefaultCrawler")
@Scope("prototype")
public class DefaultCrawler extends Crawler {

    @Resource(name = "ParseServiceImpl")
    private ParseService service;

    @Resource(name = "Config")
    private Config config;

    @Override
    public void visit(Page page, Links nextLinks) {
        for(Pattern p : patterns){
            if(p.matcher(page.getUrl()).matches()){
                service.parse(page , DefaultCrawler.class);
                break;
            }
        }
    }

    @Override
    public String getCrawlPath() {
        return String.format("%s%s%s" , config.get("crawlerPath") , File.separator , crawlerInfo.getId());
    }
}
