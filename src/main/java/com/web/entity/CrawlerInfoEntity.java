package com.web.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

/**
 * @author jayson   2015-08-11 15:19
 * @since v1.0
 */
@Entity(name = "CrawlerInfoEntity")
@Table(name = "CrawlerInfo")
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

    @Column(name = "resumable")
    private boolean resumable;

    @ElementCollection
    @Column(name = "seeds")
    private List<String> seeds;

    @ElementCollection
    @Column(name = "regex")
    private List<String> regex;

    @ElementCollection
    @Column(name = "matching")
    private List<String> matching;

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

    public boolean isResumable() {
        return resumable;
    }

    public void setResumable(boolean resumable) {
        this.resumable = resumable;
    }

    public List<String> getSeeds() {
        return seeds;
    }

    public void setSeeds(List<String> seeds) {
        this.seeds = seeds;
    }

    public List<String> getRegex() {
        return regex;
    }

    public void setRegex(List<String> regex) {
        this.regex = regex;
    }

    public List<String> getMatching() {
        return matching;
    }

    public void setMatching(List<String> matching) {
        this.matching = matching;
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
