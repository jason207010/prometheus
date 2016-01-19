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
 * @author jayson  <br/> 2015-12-12 11:00
 * @since v1.0
 */
@Component("CustomFilterInvocationSecurityMetadataSource")
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private RoleService roleService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        FilterInvocation invocation = (FilterInvocation) o;
        String servletPath = invocation.getRequest().getServletPath();

        System.err.printf("servletPath:%s\r\n" , servletPath);

        List<ConfigAttribute> configAttributes = new ArrayList<>();

        ResourceEntity resourceEntity = resourceService.findByUrl(servletPath);

        if(resourceEntity == null)
            return configAttributes;

        List<RoleEntity> roleEntities = resourceEntity.getRoleEntities();


        if(roleEntities == null || roleEntities.isEmpty()){
            ConfigAttribute attribute = new SecurityConfig("forbid");
            configAttributes.add(attribute);
            return configAttributes;
        }

        for(RoleEntity re : roleEntities){
            ConfigAttribute attribute = new SecurityConfig(re.getName());
            configAttributes.add(attribute);
        }

        return configAttributes;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        List<RoleEntity> roleEntities = roleService.findAll();

        List<ConfigAttribute> configAttributes = new ArrayList<>();

        if(roleEntities == null || roleEntities.isEmpty())
            return configAttributes;

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
