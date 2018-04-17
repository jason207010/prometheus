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
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    private Pattern pattern1 = Pattern.compile("posted @ (\\d+-\\d+-\\d+ \\d+:\\d+) (\\S+)\\s.+");

    private Pattern pattern2 = Pattern.compile("(\\d+-\\d+-\\d+ \\d+:\\d+) by (\\S+),.+");


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
        Document doc = page.getDoc();
        if(!doc.select("#tb_password").isEmpty())
            return;

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

        String title = doc.title();
        String content = doc.text();
        String html = doc.html();
        int statusCode = page.getResponse().getCode();
        String contentType = page.getResponse().getContentType();
        Map<String, List<String>> headersMap = page.getResponse().getHeaders();
        String headers = JSON.toJSONString(headersMap);

        Elements elements = doc.select("#cb_post_title_url");
        if(elements.isEmpty())
            parseStyle1(doc, webPageEntity);
        else
            parseStyle2(doc, webPageEntity);

        if(webPageEntity.getId() == 0L) webPageEntity.setId(webPageService.increaseAndGetId());

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
        webPageEntity.setCategory("");
        webPageEntity.setTag("");
        webPageEntity.setCrawleTime(new Timestamp(System.currentTimeMillis()));

        WebPageTask webPageTask = factory.create(WebPageTask.class);
        webPageTask.setEntity(webPageEntity);
        webPageTaskScheduler.schedule(webPageTask);

        LuceneTask luceneTask = factory.create(LuceneTask.class);
        luceneTask.setEntity(webPageEntity);
        luceneTaskScheduler.schedule(luceneTask);

    }

    private void parseStyle1(Document doc, WebPageEntity webPageEntity) throws Exception {
        String articleTitle = doc.select(".postTitle2").text();
        String articleBody = doc.select(".postCon").text();
        String postDesc = doc.select(".postDesc").text();
        Matcher matcher = pattern1.matcher(postDesc);
        matcher.matches();
        String author = matcher.group(2);
        String releaseTimeStr = matcher.group(1);
        Timestamp releaseTime = new Timestamp(threadLocal.get().parse(releaseTimeStr).getTime());

        webPageEntity.setArticleTitle(articleTitle);
        webPageEntity.setArticleBody(articleBody);
        webPageEntity.setReleaseTime(releaseTime);
        webPageEntity.setAuthor(author);
    }

    private void parseStyle2(Document doc, WebPageEntity webPageEntity) throws Exception {
        String articleTitle = doc.select("#cb_post_title_url").text();
        String articleBody = doc.select("#cnblogs_post_body").text();
        String postDesc = doc.select("#post small").text();
        String author;
        String releaseTimeStr = null;
        Timestamp releaseTime;
        if(StringUtils.isNotBlank(postDesc)) {
            Matcher matcher = pattern2.matcher(postDesc);
            matcher.matches();
            releaseTimeStr = matcher.group(1);
            releaseTime = new Timestamp(threadLocal.get().parse(releaseTimeStr).getTime());
            author = matcher.group(2);
        } else {
            releaseTimeStr = doc.select("#post-date").text();
            releaseTime = new Timestamp(threadLocal.get().parse(releaseTimeStr).getTime());
            author = doc.select("#post-date+a").text();
        }

        webPageEntity.setArticleTitle(articleTitle);
        webPageEntity.setArticleBody(articleBody);
        webPageEntity.setReleaseTime(releaseTime);
        webPageEntity.setAuthor(author);
    }

    @Override
    public Class<CNBlogsCrawler> getBindCrawler() {
        return CNBlogsCrawler.class;
    }
}
