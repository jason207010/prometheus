package com.web.entity;

import javax.persistence.*;

/**
 * @author jayson  <br/> 2015-12-12 16:11
 * @since v1.0
 */
@Entity(name = "MenuEntity")
@Table(name = "menu")
public class MenuEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private long id;
    @Column(name = "`name`")
    private String name;
    @OneToOne
    @JoinColumn(name = "id")
    private MenuEntity menuEntity;
    @OneToOne
    @JoinColumn(name = "resource_id")
    private ResourceEntity resourceEntity;

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

    public MenuEntity getMenuEntity() {
        return menuEntity;
    }

    public void setMenuEntity(MenuEntity menuEntity) {
        this.menuEntity = menuEntity;
    }

    public ResourceEntity getResourceEntity() {
        return resourceEntity;
    }

    public void setResourceEntity(ResourceEntity resourceEntity) {
        this.resourceEntity = resourceEntity;
    }
}
