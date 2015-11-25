package com.web.executor.webpage;

import com.web.entity.WebPageEntity;
import com.web.executor.Task;
import com.web.service.WebPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author jayson  <br/> 2015-11-25 17:46
 * @since v1.0
 */
@Component("WebPageTask")
@Scope("prototype")
public class WebPageTask implements Task {

    @Autowired
    private WebPageService service;

    private WebPageEntity entity;
    @Override
    public void execute() {
        service.save(entity);
    }

    public void setEntity(WebPageEntity entity) {
        this.entity = entity;
    }
}
