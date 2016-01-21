package com.web.service;

import com.web.entity.UserEntity;

import java.util.List;

/**
 * @author jayson  <br/> 2015-12-12 16:53
 * @since v1.0
 */
public interface UserService {
    public UserEntity findByName(String name);
    public List<UserEntity> findAll();
    public UserEntity save(UserEntity userEntity);
    public UserEntity findOne(Long id);
    public void delete(Long id);
}
