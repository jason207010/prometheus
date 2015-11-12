package com.web.config;

import org.springframework.stereotype.Component;

/**
 * @author jayson   2015-07-14-21:52
 * @since v1.0
 */
@Component("Config")
public class Config extends ReloadableProperties{
    @Override
    protected String getClassPathFilePath() {
        return "config.properties";
    }

    public long getStartId(){
        return Long.parseLong(properties.getProperty("startId"));
    }
}