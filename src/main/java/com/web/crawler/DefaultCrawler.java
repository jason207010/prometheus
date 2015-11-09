package com.web.crawler;

import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.model.Page;
import com.web.service.ParseService;
import com.web.config.Config;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
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

    private List<Pattern> patterns = new ArrayList<>();

    @Override
    public void visit(Page page, Links nextLinks) {
        if(patterns.isEmpty() && crawlerInfo.getMatching() != null && !crawlerInfo.getMatching().isEmpty()){
            for(String m : crawlerInfo.getMatching())
                patterns.add(Pattern.compile(m));
        }

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
