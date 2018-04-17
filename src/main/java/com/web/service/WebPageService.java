package com.web.service;

import com.web.entity.WebPageEntity;

/**
 * @author Jayson Chan<br/>2015-11-12 22:08
 * @since v1.0
 */
public interface WebPageService {
    public void save(Iterable<WebPageEntity> iterable);
    public void save(WebPageEntity entity);
    public WebPageEntity get(long crc , String url , String viceUrl);
    WebPageEntity getById(long id);
    long increaseAndGetId();
}
