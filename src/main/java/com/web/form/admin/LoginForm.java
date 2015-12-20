package com.web.form.admin;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author jayson  <br/> 2015-12-14 21:23
 * @since v1.0
 */
public class LoginForm {
    @NotBlank(message = "请填写用户名！")
    private String name;
    @NotBlank(message = "请填写密码！")
    private String password;

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
}
