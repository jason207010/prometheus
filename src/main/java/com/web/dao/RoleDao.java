package com.web.dao;

import com.web.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jayson  <br/> 2015-12-14 19:56
 * @since v1.0
 */
public interface RoleDao extends JpaRepository<RoleEntity , Long> {
}
