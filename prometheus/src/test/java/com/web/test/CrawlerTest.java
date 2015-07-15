package com.web.test;

import cn.edu.hfut.dmic.webcollector.util.FileUtils;
import org.junit.Test;

import java.io.File;

/**
 * @author jayson   2015-07-10-20:53
 * @since v1.0
 */
public class CrawlerTest {
    @Test
    public void test(){
        File dir = new File("E:\\data");
        if(dir.exists()){
            FileUtils.deleteDir(dir);
        }
        dir.mkdirs();
    }
}
