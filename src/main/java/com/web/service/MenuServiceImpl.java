package com.web.service;

import com.web.dao.MenuDao;
import com.web.entity.MenuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jayson  <br/> 2015-12-17 20:05
 * @since v1.0
 */
@Service("MenuServiceImpl")
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    @Transactional(readOnly = true)
    public List<MenuEntity> findAll() {
        return menuDao.findAll();
    }
}
