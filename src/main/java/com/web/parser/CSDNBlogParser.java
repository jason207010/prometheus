package com.web.parser;

import cn.edu.hfut.dmic.webcollector.model.Page;
import com.web.annotation.BindCrawler;
import com.web.crawler.CSDNBlogCrawler;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author jayson   2015-08-13 17:18
 * @since v1.0
 */
@Component("CSDNBlogParser")
@BindCrawler(clazz = CSDNBlogCrawler.class)
public class CSDNBlogParser implements Parser {
    private static final Logger LOGGER = LoggerFactory.getLogger(CSDNBlogParser.class);
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

        LOGGER.debug(url);
        LOGGER.debug(title);
        LOGGER.debug(content);
        LOGGER.debug(author);
        LOGGER.debug(postDate);
    }
}
