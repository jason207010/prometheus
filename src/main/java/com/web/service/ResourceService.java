package com.web.service;

import com.web.entity.ResourceEntity;

import java.util.List;

/**
 * @author jayson  <br/> 2015-12-14 19:34
 * @since v1.0
 */
public interface ResourceService {
    public ResourceEntity findByUrl(String url);
    public void add(ResourceEntity entity);
    public List<ResourceEntity> findAll();
}
