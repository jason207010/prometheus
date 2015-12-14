package com.web.service;

import com.web.dao.RoleDao;
import com.web.entity.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jayson  <br/> 2015-12-14 19:55
 * @since v1.0
 */
@Service("RoleServiceImpl")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<RoleEntity> findAll() {
        return roleDao.findAll();
    }
}
