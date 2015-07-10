package com.web.analyser;

import cn.edu.hfut.dmic.webcollector.model.Page;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author jayson   2015-07-10-17:02
 * @since v1.0
 */
@Component
@Scope("prototype")
public class AnalyserPage {
    private Analyser analyser;
    private Page page;

    /**getter、setter方法**/
    public Analyser getAnalyser() {
        return analyser;
    }

    public void setAnalyser(Analyser analyser) {
        this.analyser = analyser;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
