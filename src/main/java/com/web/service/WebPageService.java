package com.web.service;

import com.web.entity.WebPageEntity;

/**
 * @author Jayson Chan<br/>2015-11-12 22:08
 * @since v1.0
 */
public interface WebPageService {
    public void scheduleSave(WebPageEntity entity);
    public void save(Iterable<WebPageEntity> iterator);
}
