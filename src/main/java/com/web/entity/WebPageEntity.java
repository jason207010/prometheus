package com.web.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author jayson   2015-07-21-16:19
 * @since v1.0
 */
@Entity(name = "WebPageEntity")
@Table(name = "WebPage")
public class WebPageEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private long id;

    @Column(name = "crc")
    private long crc;

    @Column(name = "url")
    private String url;

    @Column(name = "vice_url")
    private String viceUrl;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "html")
    private String html;

    @Column(name = "status_code")
    private int statusCode;

    @Column(name = "content_type")
    private String contentType;

    @Column(name = "headers")
    private String headers;

    @Column(name = "md5")
    private String md5;

    @Column(name = "article_title")
    private String articleTitle;

    @Column(name = "article_body")
    private String articleBody;

    @Column(name = "category")
    private String category;

    @Column(name = "tag")
    private String tag;

    @Column(name = "release_time")
    private Timestamp releaseTime;

    @Column(name = "author")
    private String author;

    @Column(name = "crawle_time")
    private Timestamp crawleTime;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Timestamp getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Timestamp releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Timestamp getCrawleTime() {
        return crawleTime;
    }

    public void setCrawleTime(Timestamp crawleTime) {
        this.crawleTime = crawleTime;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }
}
