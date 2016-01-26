package com.web.parser;

import cn.edu.hfut.dmic.webcollector.model.Page;
import com.alibaba.fastjson.JSON;
import com.web.crawler.CSDNBlogCrawler;
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
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author jayson   2015-08-13 17:18
 * @since v1.0
 */
@Component("CSDNBlogParser")
public class CSDNBlogParser implements Parser<CSDNBlogCrawler> {

    private ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm");
        }
    };

    @Autowired
    private WebPageTaskScheduler webPageTaskScheduler;

    @Autowired
    private WebPageService webPageService;

    @Autowired
    private LuceneTaskScheduler luceneTaskScheduler;

    @Autowired
    private SpringFactory factory;

    @Override
    public Class<CSDNBlogCrawler> getBindCrawler() {
        return CSDNBlogCrawler.class;
    }

    @Override
    public void parse(Page page) throws Exception {

        Document doc = page.getDoc();
        String url = page.getUrl();//网页url
        long crc = CRC32.crc32(url);//网页url的crc32
        String viceUrl = "";//副url，如ajax翻页的url
        String md5 = MessageDigestUtils.md5Hex(page.getContent());//整个网页的md5

        WebPageEntity entity = webPageService.get(crc, url, viceUrl);//从数据库取出符合的网页实体
        if (entity == null){
            entity = new WebPageEntity();
        } else {
            if(md5.equals(entity.getMd5()))//数据库中已保存有该网页，且md5相同
                return;
        }

        String title = doc.title();//网页标题
        String content = doc.text();//网页纯文字
        String html = page.getHtml();//网页html代码
        int statusCode = page.getResponse().getCode();//服务器返回状态码
        String contentType = page.getResponse().getContentType();//内容类型
        Map<String, List<String>> headersMap = page.getResponse().getHeaders();//网页头
        String headers = JSON.toJSONString(headersMap);//网页头转为JSON格式


        String articleTitle = doc.select(".article_title a").text();//文章标题
        String articleBody = doc.select(".article_content").text();//文章内容

        List<String> categoryList = new ArrayList<>();
        Elements categories = doc.select("div.category_r label span");
        for(Element e : categories){
            categoryList.add(e.text());
        }
        String category = JSON.toJSONString(categoryList);//文章所属分类JSON

        List<String> tagList = new ArrayList<>();
        Elements tags = doc.select("span.link_categories>a");
        for(Element e : tags){
            tagList.add(e.text());
        }
        String tag = JSON.toJSONString(tagList);//文章所属标签JSON

        String releaseTimeStr = doc.select(".link_postdate").text();
        Timestamp releaseTime = null;//文章发布时间
        if(StringUtils.isNotBlank(releaseTimeStr))
            releaseTime = new Timestamp(threadLocal.get().parse(releaseTimeStr).getTime());

        String author = doc.select("#panel_Profile #blog_userface a.user_name").text();//文章作者

        Timestamp crawlerTime = new Timestamp(System.currentTimeMillis());//爬取时间


        entity.setCrc(crc);
        entity.setUrl(url);
        entity.setViceUrl(viceUrl);
        entity.setTitle(title);
        entity.setContent(content);
        entity.setHtml(html);
        entity.setStatusCode(statusCode);
        entity.setContentType(contentType);
        entity.setHeaders(headers);
        entity.setMd5(md5);
        entity.setArticleTitle(articleTitle);
        entity.setArticleBody(articleBody);
        entity.setCategory(category);
        entity.setTag(tag);
        entity.setReleaseTime(releaseTime);
        entity.setAuthor(author);
        entity.setCrawleTime(crawlerTime);

        WebPageTask webPageTask = factory.create(WebPageTask.class);
        webPageTask.setEntity(entity);
        webPageTaskScheduler.schedule(webPageTask);

        LuceneTask luceneTask = factory.create(LuceneTask.class);
        luceneTask.setEntity(entity);
        luceneTaskScheduler.schedule(luceneTask);
    }
}