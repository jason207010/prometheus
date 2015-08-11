package com.web.service;

import com.web.dao.TestDao;
import com.web.entity.WebPageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jayson   2015-07-21-17:33
 * @since v1.0
 */
@Service("TestServiceImpl")
public class TestServiceImpl {
    @Autowired
    private TestDao dao;
    @Transactional(readOnly = true)
    public List<WebPageEntity> list(){
        List<WebPageEntity> list = dao.findAll();
        return list;
    }
    @Transactional
    public void save(WebPageEntity page){
        dao.save(page);
    }
}
