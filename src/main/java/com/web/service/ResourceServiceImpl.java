package com.web.service;

import com.web.dao.ResourceDao;
import com.web.entity.ResourceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jayson  <br/> 2015-12-14 19:34
 * @since v1.0
 */
@Service("ResourceServiceImpl")
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceDao resourceDao;

    @Override
    public ResourceEntity findByUrl(String url) {
        return resourceDao.findByUrl(url);
    }
}
