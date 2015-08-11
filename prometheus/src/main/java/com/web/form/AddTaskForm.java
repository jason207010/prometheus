package com.web.form;

import org.hibernate.validator.constraints.NotBlank;
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
    @NotBlank
    private String desc;
    @Min(1)
    @NotNull
    private Integer topN;
    @NotNull
    private Boolean autoParse = false;
    @Min(1)
    @NotNull
    private Integer threadNum;
    @NotNull
    private Boolean resumable = false;
    @NotBlank
    private String seeds;
    @NotBlank
    private String regex;
    @Min(1)
    @Max(5)
    @NotNull
    private Integer maxRetry;
    @Min(1)
    @NotNull
    private Integer retry;
    @Min(1)
    @NotNull
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

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getSeeds() {
        return seeds;
    }

    public void setSeeds(String seeds) {
        this.seeds = seeds;
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
