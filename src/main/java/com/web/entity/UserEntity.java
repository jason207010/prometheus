package com.web.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author jayson  <br/> 2015-12-12 15:14
 * @since v1.0
 */
@Entity(name = "UserEntity")
@Table(name = "user")
public class UserEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private long id;
    @Column(name = "name" , nullable = false)
    private String name;
    @Column(name = "password" , nullable = false)
    private String password;
    @Column(name = "enable" , nullable = false)
    private boolean enable = true;
    @ManyToMany
    @JoinTable(
            name = "user_role" ,
            joinColumns = {@JoinColumn(name = "user_id" , referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id" , referencedColumnName = "id")}
    )
    private List<RoleEntity> roleEntities;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public List<RoleEntity> getRoleEntities() {
        return roleEntities;
    }

    public void setRoleEntities(List<RoleEntity> roleEntities) {
        this.roleEntities = roleEntities;
    }
}
