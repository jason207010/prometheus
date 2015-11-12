package com.web.dao;

import com.web.entity.CrawlerInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author jayson   2015-08-11 15:30
 * @since v1.0
 */
public interface CrawlerInfoDao extends JpaRepository<CrawlerInfoEntity, Long> {
    @Query("select max(id) from CrawlerInfo")
    public long maxId();
}
