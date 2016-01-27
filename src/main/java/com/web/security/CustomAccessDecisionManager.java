package com.web.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 自定义权限决定器，根据用户是否拥有某资源的权限，从而决定是否让用户访问某资源
 * @author jayson  <br/> 2015-12-11 17:16
 * @since v1.0
 */
@Component("CustomAccessDecisionManager")
public class CustomAccessDecisionManager implements AccessDecisionManager {

    /**
     * 如果用户拥有访问权限，则直接return。如果没有访问权限，那么抛出AccessDeniedException异常
     * 这个异常会被spring security检测到，从而引导到403页面
     * @param authentication 当前用户
     * @param o
     * @param collection 当前用户所访问的资源需要的权限
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {

        if(collection == null || collection.isEmpty())//如果不需要角色权限
            return;

        //当前用户所拥有的权限
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        if(authentication.getName().equals("admin"))//超级管理员拥有所有权限
            return;

        //遍历，判断当前用户是否具有访问权限
        for(ConfigAttribute ca : collection){
            for (GrantedAuthority ga : authorities){
                if(ca.getAttribute().equals(ga.getAuthority()))
                    return;
            }
        }

        throw new AccessDeniedException("没有访问权限！");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}