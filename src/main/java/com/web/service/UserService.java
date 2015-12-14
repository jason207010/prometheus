package com.web.service;

import com.web.entity.UserEntity;

/**
 * @author jayson  <br/> 2015-12-12 16:53
 * @since v1.0
 */
public interface UserService {
    public UserEntity findByName(String name);
}
