package com.web.crawler;

/**
 * @author jayson   2015-07-11-16:59
 * @since v1.0
 */
public enum CrawlerTaskStatus {
    Running("运行中"),
    Stop("已停止");

    private String desc;

    CrawlerTaskStatus(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
