package com.web.parser;

import cn.edu.hfut.dmic.webcollector.model.Page;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author jayson   2015-07-12 17:31
 * @since v1.0
 */
@Component("ParseTaskImpl")
@Scope("prototype")
public class ParseTaskImpl implements ParseTask {
    private Parser parser;
    private Page page;
    @Override
    public void execute() {
        parser.parse(page);
    }

    @Override
    public void setParser(Parser parser) {
        this.parser = parser;
    }

    @Override
    public void setPage(Page page) {
        this.page = page;
    }
}
