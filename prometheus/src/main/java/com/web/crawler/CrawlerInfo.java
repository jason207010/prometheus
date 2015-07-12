package com.web.crawler;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jayson   2015-07-11-11:48
 * @since v1.0
 */
@Component("CrawlerInfo")
@Scope("prototype")
public class CrawlerInfo {
    private long id;
    private String desc;
    private int topN;
    private boolean autoParse;
    private String crawlPath;
    private int threadNum;
    private boolean resumable;
    private List<String> seed = new ArrayList<>();
    private List<String> regex = new ArrayList<>();
    private int maxRetry;
    private int retry;
    private int depth;
    public boolean addSeed(String seed){
        if(StringUtils.isBlank(seed))
            return false;
        return this.seed.add(seed);
    }
    public boolean addRegex(String regex){
        if(StringUtils.isBlank(regex))
            return false;
        return this.regex.add(regex);
    }
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

    public List<String> getSeed() {
        return seed;
    }

    public void setSeed(List<String> seed) {
        this.seed = seed;
    }

    public List<String> getRegex() {
        return regex;
    }

    public void setRegex(List<String> regex) {
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
