package com.web.dao;

import com.web.entity.WebPageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Jayson Chan<br/>2015-11-12 22:07
 * @since v1.0
 */
public interface WebPageDao extends JpaRepository<WebPageEntity, Long> {

}
