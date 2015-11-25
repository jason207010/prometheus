package com.web.service;

import cn.edu.hfut.dmic.webcollector.model.Page;
import com.web.entity.WebPageEntity;
import com.web.lucene.Indexer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jayson   2015-07-22-14:59
 * @since v1.0
 */
@Service("LuceneServiceImpl")
public class LuceneServiceImpl implements LuceneService {

    @Autowired
    private Indexer indexer;

    @Override
    public void saveOrUpdate(WebPageEntity entity) {

    }
}
