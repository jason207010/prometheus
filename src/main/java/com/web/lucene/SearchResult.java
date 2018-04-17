package com.web.lucene;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author jayson  <br/> 2015-12-01 20:22
 * @since v1.0
 */
@Component("SearchResult")
@Scope("prototype")
public class SearchResult {
    private long id;
    private long crc;
    private String url;
    private String viceUrl;
    private String author;
    private String articleTitle;
    private String articleBody;

    /**getter、setter方法**/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCrc() {
        return crc;
    }

    public void setCrc(long crc) {
        this.crc = crc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getViceUrl() {
        return viceUrl;
    }

    public void setViceUrl(String viceUrl) {
        this.viceUrl = viceUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleBody() {
        return articleBody;
    }

    public void setArticleBody(String articleBody) {
        this.articleBody = articleBody;
    }
}
