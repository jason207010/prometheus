package com.web.parser.task;

import cn.edu.hfut.dmic.webcollector.model.Page;
import com.web.parser.Parser;
import com.web.task.Task;

/**
 * @author jayson   2015-07-10-17:28
 * @since v1.0
 */
public interface ParseTask extends Task {
    public void setParser(Parser parser);
    public void setPage(Page page);
}
