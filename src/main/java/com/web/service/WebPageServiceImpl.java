package com.web.service;

import com.web.dao.WebPageDao;
import com.web.entity.WebPageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Jayson Chan<br/>2015-11-12 22:10
 * @since v1.0
 */
@Component("WebPageServiceImpl")
@Transactional
public class WebPageServiceImpl implements WebPageService {

    private AtomicLong maxId;

    @Autowired
    private WebPageDao dao;

    @PostConstruct
    public void init() {
        Long maxId = dao.getMaxId();
        if(maxId == null)
            maxId = 0L;
        this.maxId = new AtomicLong(maxId);
    }

    @Override
    public void save(Iterable<WebPageEntity> iterable) {
        dao.save(iterable);
    }

    @Override
    public void save(WebPageEntity entity) {
        dao.save(entity);
    }

    @Override
    public WebPageEntity get(long crc, String url, String viceUrl) {
        return dao.get(crc , url , viceUrl);
    }

    @Override
    public WebPageEntity getById(long id) {
        return dao.getById(id);
    }

    @Override
    public long increaseAndGetId() {
        return maxId.incrementAndGet();
    }
}
