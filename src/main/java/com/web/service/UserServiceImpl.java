package com.web.service;

import com.web.dao.UserDao;
import com.web.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jayson  <br/> 2015-12-12 17:04
 * @since v1.0
 */
@Service("UserServiceImpl")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserEntity findByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public List<UserEntity> findAll() {
        return userDao.findAll();
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        return userDao.save(userEntity);
    }

    @Override
    public UserEntity findOne(Long id) {
        return userDao.findOne(id);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }
}
