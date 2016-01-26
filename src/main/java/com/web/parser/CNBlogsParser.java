package com.web.parser;

import cn.edu.hfut.dmic.webcollector.model.Page;
import com.alibaba.fastjson.JSON;
import com.web.crawler.CNBlogsCrawler;
import com.web.entity.WebPageEntity;
import com.web.executor.lucene.LuceneTask;
import com.web.executor.webpage.WebPageTask;
import com.web.scheduler.LuceneTaskScheduler;
import com.web.scheduler.WebPageTaskScheduler;
import com.web.service.WebPageService;
import com.web.util.SpringFactory;
import com.web.util.digest.CRC32;
import com.web.util.digest.MessageDigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * @author jayson  <br/> 2016-01-25 15:06
 * @since v1.0
 */
@Component("CNBlogsParser")
public class CNBlogsParser implements Parser<CNBlogsCrawler> {

    private ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm");
        }
    };

    @Autowired
    private WebPageService webPageService;

    @Autowired
    private SpringFactory factory;

    @Autowired
    private WebPageTaskScheduler webPageTaskScheduler;

    @Autowired
    private LuceneTaskScheduler luceneTaskScheduler;

    @Override
    public void parse(Page page) throws Exception {
        String url = page.getUrl();
        long crc = CRC32.crc32(url);
        String viceUrl = "";
        String md5 = MessageDigestUtils.md5Hex(page.getContent());
        WebPageEntity webPageEntity = webPageService.get(crc, url, viceUrl);
        if(webPageEntity == null){
            webPageEntity = new WebPageEntity();
        } else {

            if(md5.equals(webPageEntity.getMd5()))
                return;
        }

        Document doc = page.getDoc();
        String title = doc.title();
        String content = doc.text();
        String html = doc.html();
        int statusCode = page.getResponse().getCode();
        String contentType = page.getResponse().getContentType();
        Map<String, List<String>> headersMap = page.getResponse().getHeaders();
        String headers = JSON.toJSONString(headersMap);
        String articleTitle = doc.select("#cb_post_title_url").text();
        String articleBody = doc.select("div#cnblogs_post_body").text();
        String releaseTimeStr = doc.select("#post-date").text();
        Timestamp releaseTime = null;
        if(StringUtils.isNotBlank(releaseTimeStr)){
            releaseTime = new Timestamp(threadLocal.get().parse(releaseTimeStr).getTime());
        }
        String author = doc.select("#post-date+a").text();


        webPageEntity.setCrc(crc);
        webPageEntity.setUrl(url);
        webPageEntity.setViceUrl(viceUrl);
        webPageEntity.setTitle(title);
        webPageEntity.setContent(content);
        webPageEntity.setHtml(html);
        webPageEntity.setStatusCode(statusCode);
        webPageEntity.setContentType(contentType);
        webPageEntity.setHeaders(headers);
        webPageEntity.setMd5(md5);
        webPageEntity.setArticleTitle(articleTitle);
        webPageEntity.setArticleBody(articleBody);
        webPageEntity.setCategory("");
        webPageEntity.setTag("");
        webPageEntity.setReleaseTime(releaseTime);
        webPageEntity.setAuthor(author);
        webPageEntity.setCrawleTime(new Timestamp(System.currentTimeMillis()));

        WebPageTask webPageTask = factory.create(WebPageTask.class);
        webPageTask.setEntity(webPageEntity);
        webPageTaskScheduler.schedule(webPageTask);

        LuceneTask luceneTask = factory.create(LuceneTask.class);
        luceneTask.setEntity(webPageEntity);
        luceneTaskScheduler.schedule(luceneTask);

    }

    @Override
    public Class<CNBlogsCrawler> getBindCrawler() {
        return CNBlogsCrawler.class;
    }
}
