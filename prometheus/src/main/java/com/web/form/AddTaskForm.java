package com.web.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jayson   2015-07-13-14:29
 * @since v1.0
 */
public class AddTaskForm {
    private String desc;
    @Min(1)
    private Integer topN;
    @NotNull
    private Boolean autoParse = false;
    @Min(1)
    private Integer threadNum;
    @NotNull
    private Boolean resumable = false;
    @NotEmpty
    private List<String> seed = new ArrayList<>();
    @NotEmpty
    private List<String> regex = new ArrayList<>();
    @Min(1)
    @Max(5)
    private Integer maxRetry;
    @Min(1)
    private Integer retry;
    @Min(1)
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
