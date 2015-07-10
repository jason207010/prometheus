package com.web.analyser;

import cn.edu.hfut.dmic.webcollector.model.Page;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author jayson   2015-07-10-17:28
 * @since v1.0
 */
@Component("AnalyseTask")
@Scope("prototype")
public class AnalyseTask implements Runnable {
    private Analyser analyser;
    private Page page;

    @Override
    public void run() {
        analyser.analyse(page);
    }

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
