package com.web.service;

import cn.edu.hfut.dmic.webcollector.model.Page;
import com.web.analyser.AnalyseTask;
import com.web.util.SpringFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jayson   2015-07-12 17:01
 * @since v1.0
 */
@Component("AnalyseManagerImpl")
public class AnalyseServiceImpl implements AnalyseService {
    @Autowired
    private SpringFactory factory;
    @Override
    public void analyse(Page page) {
        factory.create(AnalyseTask.class);
    }
}
