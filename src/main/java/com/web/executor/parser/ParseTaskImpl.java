package com.web.executor.parser;

import cn.edu.hfut.dmic.webcollector.model.Page;
import com.web.parser.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author jayson   2015-07-12 17:31
 * @since v1.0
 */
@Component("ParseTaskImpl")
@Scope("prototype")
public class ParseTaskImpl implements ParseTask {
    private static final Logger LOGGER = LoggerFactory.getLogger(ParseTaskImpl.class);

    private Parser parser;
    private Page page;
    @Override
    public void execute() {
        try {
            parser.parse(page);
        } catch (Exception e) {
            LOGGER.error("" + page.getUrl() , e);
        }
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
