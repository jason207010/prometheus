package com.web.dao;

import com.web.entity.WebPage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jayson   2015-07-14-14:57
 * @since v1.0
 */
public interface TestDao extends JpaRepository<WebPage , Long> {

}