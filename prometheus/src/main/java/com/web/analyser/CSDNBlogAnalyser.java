package com.web.analyser;

import cn.edu.hfut.dmic.webcollector.model.Page;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author jayson   2015-07-12 17:32
 * @since v1.0
 */
@Component("CSDNBlogAnalyser")
@Scope("prototype")
public class CSDNBlogAnalyser implements Analyser {
    @Override
    public void analyse(Page page) {

    }
}
