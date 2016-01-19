package com.web.service;

import com.web.entity.MenuEntity;

import java.util.List;

/**
 * @author jayson  <br/> 2015-12-17 20:04
 * @since v1.0
 */
public interface MenuService {
    public List<MenuEntity> findAll();
    public MenuEntity save(MenuEntity entity);
    public MenuEntity findOne(Long id);
    public void delete(Long id);
}
