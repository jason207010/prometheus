package com.web.dao;

import com.web.entity.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jayson  <br/> 2015-12-14 19:33
 * @since v1.0
 */
public interface ResourceDao extends JpaRepository<ResourceEntity , Long> {

    public ResourceEntity findByUrl(String url);

}
