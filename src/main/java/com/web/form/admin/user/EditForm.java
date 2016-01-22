package com.web.form.admin.user;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author jayson  <br/> 2016-01-21 16:02
 * @since v1.0
 */
public class EditForm {
    @NotNull
    private Long id;

    @NotNull(message = "请输入用户名")
    @NotBlank(message = "请输入用户名")
    @Size(max = 32 , message = "用户名最多32个字符")
    private String name;

    @NotNull(message = "请输入密码")
    @NotBlank(message = "请输入密码")
    @Size(max = 512 , message = "密码过长")
    private String password;

    @NotNull
    private Boolean enable;

    private List<Long> roleIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }
}
