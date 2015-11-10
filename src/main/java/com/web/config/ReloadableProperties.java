package com.web.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Jayson Chan<br/>2015-11-09 15:36
 * @since v1.0
 */
public abstract class ReloadableProperties extends ReloadableConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReloadableProperties.class);

    protected Properties properties = null;

    public ReloadableProperties(){
        super();
        reload();
    }

    @Override
    public void reload() {
        ClassPathResource resource = new ClassPathResource(getClassPathFilePath());
        properties = new Properties();
        try {
            properties.load(resource.getInputStream());
        } catch (IOException e) {
            LOGGER.error("ClassPathFilePath:{}" , getClassPathFilePath());
            LOGGER.error("" , e);
        }
    }

    public String get(String key){
        return properties.getProperty(key);
    }
}
