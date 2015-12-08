package com.web.service;

import com.web.common.Page;
import com.web.entity.WebPageEntity;
import com.web.lucene.SearchResult;

/**
 * @author jayson   2015-07-22-14:59
 * @since v1.0
 */
public interface LuceneService {
    public void saveOrUpdate(WebPageEntity entity);
    public Page<SearchResult> search(String keyWord , Page<SearchResult> page);
}
