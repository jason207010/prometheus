package com.web.test;

import com.web.crawler.CSDNBlogCrawler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CSDNBlogTest {
    @Autowired
    private CSDNBlogCrawler crawler;
    @Test
    public void test() throws Exception {
        crawler.setThreads(Runtime.getRuntime().availableProcessors() + 1);
//        crawler.setResumable(true);
        crawler.setTopN(9999);
        crawler.start(30);
    }
}
