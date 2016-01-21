package com.web.form.admin.user;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author jayson  <br/> 2016-01-21 15:50
 * @since v1.0
 */
public class AddForm {
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
}
