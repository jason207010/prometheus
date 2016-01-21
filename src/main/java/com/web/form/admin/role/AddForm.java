package com.web.form.admin.role;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author jayson  <br/> 2016-01-21 11:09
 * @since v1.0
 */
public class AddForm {
    @NotNull(message = "请输入角色名")
    @NotBlank(message = "请输入角色名")
    @Size(message = "角色名最多32个字符")
    private String name;

    private List<Long> resourceIds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(List<Long> resourceIds) {
        this.resourceIds = resourceIds;
    }
}
