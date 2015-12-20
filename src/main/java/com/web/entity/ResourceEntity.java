package com.web.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

/**
 * @author jayson  <br/> 2015-12-12 15:35
 * @since v1.0
 */
@Component("ResourceEntity")
@Scope("prototype")
@Entity(name = "ResourceEntity")
@Table(name = "resource")
public class ResourceEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private long id;
    @Column(name = "url" , nullable = false)
    private String url;
    @ManyToMany(mappedBy = "resourceEntities" , fetch = FetchType.EAGER)
    private List<RoleEntity> roleEntities;

    /**getter、setter方法**/
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<RoleEntity> getRoleEntities() {
        return roleEntities;
    }

    public void setRoleEntities(List<RoleEntity> roleEntities) {
        this.roleEntities = roleEntities;
    }
}
