package com.web.form.admin.resource;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author jayson  <br/> 2016-01-21 10:42
 * @since v1.0
 */
public class EditForm {
    @NotNull
    private Long id;
    @NotNull
    @NotBlank(message = "请填写资源url")
    @Size(max = 1024 , message = "资源url最多1024个字符")
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
