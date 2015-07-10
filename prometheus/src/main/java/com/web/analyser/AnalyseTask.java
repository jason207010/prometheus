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
    private AnalyserPage ap;
    @Override
    public void run() {
        if(ap == null)
            return;

        Analyser analyser = ap.getAnalyser();
        Page page = ap.getPage();
        analyser.analyse(page);
    }

    public AnalyserPage getAp() {
        return ap;
    }

    public void setAp(AnalyserPage ap) {
        this.ap = ap;
    }
}
