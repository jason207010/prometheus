package com.web.dao;

import com.web.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jayson  <br/> 2015-12-12 16:48
 * @since v1.0
 */
public interface UserDao extends JpaRepository<UserEntity , Long> {
    public UserEntity findByName(String name);
}
