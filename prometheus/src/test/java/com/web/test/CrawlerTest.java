package com.web.test;

import com.web.service.CrawlerService;
import com.web.task.CrawlerTask;
import com.web.task.DefaultCrawlerTask;
import com.web.util.SpringFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author jayson   2015-07-10-20:53
 * @since v1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CrawlerTest {
    @Autowired
    private SpringFactory factory;

    @Autowired
    private CrawlerService service;
    public void test(){
        CrawlerTask task = factory.create(DefaultCrawlerTask.class);
        task.setDepth(5)
                .setAutoParse(true)
                .setThreads(5)
                .setTopN(100)
                .setCrawlPath("E:\\data");
        service.addTask(task);
    }
}
