package com.web.security;

import com.web.entity.RoleEntity;
import com.web.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author jayson  <br/> 2015-12-12 16:54
 * @since v1.0
 */
public class CustomUserDetails implements UserDetails {
    private UserEntity userEntity;
    private Collection<GrantedAuthority> authorities = new ArrayList<>();

    public CustomUserDetails(UserEntity userEntity) {
        this.userEntity = userEntity;
        for(RoleEntity r : userEntity.getRoleEntities()){
            GrantedAuthority authority = new SimpleGrantedAuthority(r.getName());
            authorities.add(authority);
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return userEntity.isEnable();
    }
}
