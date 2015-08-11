package com.web.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author jayson   2015-08-11 15:19
 * @since v1.0
 */
@Entity(name = "CrawlerTask")
@Component("CrawlerInfoEntity")
@Scope("prototype")
public class CrawlerInfoEntity {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "desc")
    private String desc;
    @Column(name = "topN")
    private int topN;
    @Column(name = "autoParse")
    private boolean autoParse;
    @Column(name = "crawlPath")
    private String crawlPath;
    @Column(name = "threadNum")
    private int threadNum;
    @Column(name = "resumable")
    private boolean resumable;
    @Column(name = "seeds")
    private String seeds;
    @Column(name = "regex")
    private String regex;
    @Column(name = "maxRetry")
    private int maxRetry;
    @Column(name = "retry")
    private int retry;
    @Column(name = "depth")
    private int depth;

    /**getter、setter方法**/
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getTopN() {
        return topN;
    }

    public void setTopN(int topN) {
        this.topN = topN;
    }

    public boolean isAutoParse() {
        return autoParse;
    }

    public void setAutoParse(boolean autoParse) {
        this.autoParse = autoParse;
    }

    public String getCrawlPath() {
        return crawlPath;
    }

    public void setCrawlPath(String crawlPath) {
        this.crawlPath = crawlPath;
    }

    public int getThreadNum() {
        return threadNum;
    }

    public void setThreadNum(int threadNum) {
        this.threadNum = threadNum;
    }

    public boolean isResumable() {
        return resumable;
    }

    public void setResumable(boolean resumable) {
        this.resumable = resumable;
    }

    public String getSeeds() {
        return seeds;
    }

    public void setSeeds(String seeds) {
        this.seeds = seeds;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public int getMaxRetry() {
        return maxRetry;
    }

    public void setMaxRetry(int maxRetry) {
        this.maxRetry = maxRetry;
    }

    public int getRetry() {
        return retry;
    }

    public void setRetry(int retry) {
        this.retry = retry;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
