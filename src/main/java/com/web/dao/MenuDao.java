package com.web.dao;

import com.web.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jayson  <br/> 2015-12-17 20:04
 * @since v1.0
 */
public interface MenuDao extends JpaRepository<MenuEntity , Long> {
}
