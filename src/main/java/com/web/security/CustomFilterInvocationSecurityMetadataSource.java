package com.web.security;

import com.web.entity.ResourceEntity;
import com.web.entity.RoleEntity;
import com.web.service.ResourceService;
import com.web.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 自定义权限信息数据源
 * @author jayson  <br/> 2015-12-12 11:00
 * @since v1.0
 */
@Component("CustomFilterInvocationSecurityMetadataSource")
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private RoleService roleService;

    /**
     * 根据用户访问的资源获取访问该资源所需要权限
     * @param o
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        FilterInvocation invocation = (FilterInvocation) o;
        //当前用户所访问的资源url
        String servletPath = invocation.getRequest().getServletPath();

        List<ConfigAttribute> configAttributes = new ArrayList<>();

        //从数据库中查出该资源
        ResourceEntity resourceEntity = resourceService.findByUrl(servletPath);

        //如果数据库中不存在该资源，直接返回空权限列表，表示不需要权限
        if(resourceEntity == null)
            return configAttributes;

        //访问该资源所需要的角色权限
        List<RoleEntity> roleEntities = resourceEntity.getRoleEntities();

        //如果角色权限列表为空，那么返回一个自定义的forbid权限，表示禁止访问
        if(roleEntities == null || roleEntities.isEmpty()){
            ConfigAttribute attribute = new SecurityConfig("forbid");
            configAttributes.add(attribute);
            return configAttributes;
        }

        //遍历，把角色权限加进角色权限列表中
        for(RoleEntity re : roleEntities){
            ConfigAttribute attribute = new SecurityConfig(re.getName());
            configAttributes.add(attribute);
        }

        return configAttributes;
    }

    /**
     * 获取所有角色权限
     * @return
     */
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        //从数据库查出所有角色实体
        List<RoleEntity> roleEntities = roleService.findAll();

        //所有角色权限列表
        List<ConfigAttribute> configAttributes = new ArrayList<>();

        if(roleEntities == null || roleEntities.isEmpty())
            return configAttributes;

        //遍历，把角色权限加进角色权限列表中
        for(RoleEntity re : roleEntities){
            ConfigAttribute ca = new SecurityConfig(re.getName());
            configAttributes.add(ca);
        }

        return configAttributes;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
