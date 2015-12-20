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
 * @author jayson  <br/> 2015-12-11 17:16
 * @since v1.0
 */
@Component("CustomAccessDecisionManager")
public class CustomAccessDecisionManager implements AccessDecisionManager {

    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {

        if(collection == null || collection.isEmpty())//如果不需要角色权限
            return;

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        if(authentication == null)
            throw new AccessDeniedException("没有访问权限！");

        if(authentication.getName().equals("admin"))//超级管理员拥有所有权限
            return;

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