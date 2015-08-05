package com.web.parser;

import cn.edu.hfut.dmic.webcollector.model.Page;
import com.web.task.Task;

/**
 * @author jayson   2015-07-10-17:28
 * @since v1.0
 */
public abstract class ParseTask implements Task , Runnable {
    protected Parser analyser;
    protected Page page;

    @Override
    public void run() {
        execute();
    }

    /**getter、setter方法**/
    public Parser getAnalyser() {
        return analyser;
    }

    public void setAnalyser(Parser analyser) {
        this.analyser = analyser;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
