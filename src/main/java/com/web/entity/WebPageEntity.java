package com.web.entity;

import javax.persistence.*;

/**
 * @author jayson   2015-07-21-16:19
 * @since v1.0
 */
@Entity(name = "WebPage")
public class WebPageEntity {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private byte[] content;
    @Column(name = "url")
    private String url;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
