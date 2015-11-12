package com.web.parser;

import cn.edu.hfut.dmic.webcollector.model.Page;
import com.web.crawler.CSDNBlogCrawler;
import com.web.entity.WebPageEntity;
import com.web.service.WebPageService;
import com.web.util.SpringFactory;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jayson   2015-08-13 17:18
 * @since v1.0
 */
@Component("CSDNBlogParser")
public class CSDNBlogParser implements Parser<CSDNBlogCrawler> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CSDNBlogParser.class);

    @Autowired
    private SpringFactory factory;

    @Autowired
    private WebPageService webPageService;

    @Override
    public Class<CSDNBlogCrawler> getBindCrawler() {
        return CSDNBlogCrawler.class;
    }

    @Override
    public void parse(Page page) {
        String url = page.getUrl();
        Document doc = page.getDoc();
        Elements titleElements = doc.select(".article_title a");
        String title = titleElements.text();
        Elements contentElements = doc.select(".article_content");
        String content = contentElements.text();
        Elements authorElements = doc.select(".user_name");
        String author = authorElements.text();
        Elements postDateElements = doc.select(".link_postdate");
        String postDate = postDateElements.text();

        WebPageEntity entity = factory.create(WebPageEntity.class);
        entity.setContent(content);
        entity.setTitle(title);
        entity.setUrl(url);
        webPageService.scheduleSave(entity);
    }
}
