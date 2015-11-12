package com.web.service;

import com.web.dao.WebPageDao;
import com.web.entity.WebPageEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Jayson Chan<br/>2015-11-12 22:10
 * @since v1.0
 */
@Component("WebPageServiceImpl")
@Transactional
public class WebPageServiceImpl implements WebPageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebPageServiceImpl.class);

    private BlockingQueue<WebPageEntity> queue = new LinkedBlockingQueue<>();

    @Autowired
    private WebPageDao dao;

    @PostConstruct
    public void init(){
        new Thread(()->{
            List<WebPageEntity> list = new ArrayList<>();
            while (true){
                try {
                    WebPageEntity entity = queue.poll(1, TimeUnit.MILLISECONDS);
                    if(entity == null){
                        Thread.sleep(TimeUnit.SECONDS.toMillis(3L));
                        continue;
                    }
                    list.add(entity);
                    if(list.size() >= 100){
                        save(list);
                        list = new ArrayList<>();
                    }
                } catch (InterruptedException e) {
                    LOGGER.error("" , e);
                }
            }
        }).start();
    }

    @Override
    public void scheduleSave(WebPageEntity entity) {
        try {
            queue.put(entity);
        } catch (InterruptedException e) {
            LOGGER.error("" , e);
        }
    }

    @Override
    public void save(Iterable<WebPageEntity> iterator) {
        dao.save(iterator);
    }

}
