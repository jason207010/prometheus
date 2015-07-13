package com.web.form;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jayson   2015-07-13-14:29
 * @since v1.0
 */
public class AddTaskForm {
    private String desc;
    private Integer topN;
    private Boolean autoParse = false;
    private Integer threadNum;
    private Boolean resumable = false;
    private List<String> seed = new ArrayList<>();
    private List<String> regex = new ArrayList<>();
    private Integer maxRetry;
    private Integer retry;
    private Integer depth;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getTopN() {
        return topN;
    }

    public void setTopN(Integer topN) {
        this.topN = topN;
    }

    public Boolean getAutoParse() {
        return autoParse;
    }

    public void setAutoParse(Boolean autoParse) {
        this.autoParse = autoParse;
    }

    public Integer getThreadNum() {
        return threadNum;
    }

    public void setThreadNum(Integer threadNum) {
        this.threadNum = threadNum;
    }

    public Boolean getResumable() {
        return resumable;
    }

    public void setResumable(Boolean resumable) {
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

    public Integer getMaxRetry() {
        return maxRetry;
    }

    public void setMaxRetry(Integer maxRetry) {
        this.maxRetry = maxRetry;
    }

    public Integer getRetry() {
        return retry;
    }

    public void setRetry(Integer retry) {
        this.retry = retry;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }
}
