package com.web.crawler;

import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.model.Page;
import com.alibaba.fastjson.JSON;
import com.web.entity.CrawlerInfoEntity;
import com.web.service.ParseService;
import com.web.util.Config;
import com.web.util.IDGenerator;
import com.web.util.SpringFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author jayson   2015-08-13 17:04
 * @since v1.0
 */
@Component("CSDNBlogCrawler")
public class CSDNBlogCrawler extends Crawler {
    @Resource(name = "ParseServiceImpl")
    private ParseService parseService;
    @Resource(name = "SpringFactory")
    private SpringFactory factory;
    @Resource(name = "IDGenerator")
    private IDGenerator generator;
    @Resource(name = "Config")
    private Config config;

    private Pattern pattern = Pattern.compile("^http://blog.csdn.net/\\w+/article/details/\\d+$");

    @PostConstruct
    public void init(){
        CrawlerInfoEntity crawlerInfo = factory.create(CrawlerInfoEntity.class);
        List<String> regex = new ArrayList<>();
        List<String> seed = new ArrayList<>();

        seed.add("http://blog.csdn.net/");

        regex.add("http://blog.csdn.net/.+\\.html");
        regex.add("http://blog.csdn.net/\\w+");
        regex.add("http://blog.csdn.net/\\w+/article/details/\\d+$");

        long id = generator.generate();
        crawlerInfo.setId(id);
        crawlerInfo.setAutoParse(true);
        crawlerInfo.setRetry(3);
        crawlerInfo.setMaxRetry(3);
        crawlerInfo.setDepth(10);
        crawlerInfo.setRegex(JSON.toJSONString(regex));
        crawlerInfo.setSeeds(JSON.toJSONString(seed));
        crawlerInfo.setCrawlPath(String.format("%s%s%s", config.get("crawlerPath"), File.separator, String.valueOf(id)));
        crawlerInfo.setResumable(true);
        crawlerInfo.setDesc("抓取CSDN博客");
        crawlerInfo.setThreadNum(Runtime.getRuntime().availableProcessors());
        crawlerInfo.setTopN(Integer.MAX_VALUE);
        setCrawlerInfo(crawlerInfo);
    }

    @Override
    public void visit(Page page, Links nextLinks) {
        String url = page.getUrl();
        if(!pattern.matcher(url).matches())
            return;

        parseService.parse(page , CSDNBlogCrawler.class);
    }
}
