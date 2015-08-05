package com.web.parser;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author jayson   2015-07-12 17:31
 * @since v1.0
 */
@Component("AnalyseTaskImpl")
@Scope("prototype")
public class ParseTaskImpl extends ParseTask {
    @Override
    public void execute() {
        analyser.analyse(page);
    }
}
