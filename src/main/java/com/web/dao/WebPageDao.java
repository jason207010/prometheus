package com.web.dao;

import com.web.entity.WebPageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Jayson Chan<br/>2015-11-12 22:07
 * @since v1.0
 */
public interface WebPageDao extends JpaRepository<WebPageEntity, Long> {
    @Query("select w from WebPageEntity w where w.crc=?1 and w.url=?2 and w.viceUrl=?3")
    public WebPageEntity get(long crc , String url , String viceUrl);
}
