package com.web.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author jayson  <br/> 2015-12-12 15:32
 * @since v1.0
 */
@Entity(name = "RoleEntity")
@Table(name = "role")
public class RoleEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private long id;
    @Column(name = "name" , nullable = false)
    private String name;
    @ManyToMany
    @JoinTable(
            name = "role_resource",
            joinColumns = {@JoinColumn(name = "role_id" , referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "resource_id" , referencedColumnName = "id")}
    )
    private List<ResourceEntity> resourceEntities;

    /**getter、setter方法**/
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ResourceEntity> getResourceEntities() {
        return resourceEntities;
    }

    public void setResourceEntities(List<ResourceEntity> resourceEntities) {
        this.resourceEntities = resourceEntities;
    }
}
