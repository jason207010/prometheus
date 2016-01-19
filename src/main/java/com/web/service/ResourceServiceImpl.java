package com.web.service;

import com.web.dao.ResourceDao;
import com.web.entity.ResourceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jayson  <br/> 2015-12-14 19:34
 * @since v1.0
 */
@Service("ResourceServiceImpl")
@Transactional
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceDao resourceDao;

    @Override
    @Transactional(readOnly = true)
    public ResourceEntity findByUrl(String url) {
        return resourceDao.findByUrl(url);
    }

    @Override
    public void add(ResourceEntity entity) {
        resourceDao.save(entity);
    }

    @Override
    public List<ResourceEntity> findAll() {
        return resourceDao.findAll();
    }

    @Override
    public ResourceEntity findOne(Long id) {
        return resourceDao.findOne(id);
    }
}
