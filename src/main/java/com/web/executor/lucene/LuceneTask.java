package com.web.executor.lucene;

import com.web.entity.WebPageEntity;
import com.web.executor.Task;
import com.web.service.LuceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author jayson  <br/> 2015-11-25 17:59
 * @since v1.0
 */
@Component("LuceneTask")
@Scope("prototype")
public class LuceneTask implements Task {

    @Autowired
    private LuceneService service;

    private WebPageEntity entity;

    @Override
    public void execute() {
        service.saveOrUpdate(entity);
    }

    public void setEntity(WebPageEntity entity) {
        this.entity = entity;
    }
}
