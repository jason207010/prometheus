package com.web.security;

import com.web.entity.UserEntity;
import com.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author jayson  <br/> 2015-12-11 21:22
 * @since v1.0
 */
@Service("CustomUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    /**
     * 根据用户名查找用户信息，如果查找不到，抛出UsernameNotFoundException
     * @param s 用户名
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity userEntity = userService.findByName(s);
        if(userEntity == null)
            throw new UsernameNotFoundException(String.format("username:%s not found!" , s));

        return new CustomUserDetails(userEntity);
    }
}
