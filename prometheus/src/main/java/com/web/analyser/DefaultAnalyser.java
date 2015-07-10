package com.web.analyser;

import cn.edu.hfut.dmic.webcollector.model.Page;
import com.web.annotation.BindCrawler;
import com.web.crawler.DefaultCrawler;
import org.springframework.stereotype.Component;

/**
 * @author jayson   2015-07-10-15:49
 * @since v1.0
 */
@Component("DefaultAnalyser")
@BindCrawler(clazz = DefaultCrawler.class)
public class DefaultAnalyser implements Analyser {
    @Override
    public void analyse(Page page) {
    }
}
