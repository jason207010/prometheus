package com.web.util;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * @author jayson   2015-07-14-21:52
 * @since v1.0
 */
@Component("Config")
public class Config extends FileAlterationListenerAdaptor{
    private static final Logger LOGGER = LoggerFactory.getLogger(Config.class);
    private ClassPathResource resource = new ClassPathResource("config.properties");
    private FileAlterationObserver observer = new FileAlterationObserver(resource.getPath());
    private long interval = TimeUnit.SECONDS.toMillis(30);
    private FileAlterationMonitor monitor = new FileAlterationMonitor(interval , observer);
    private Properties properties = null;

    @Override
    public void onFileChange(File file) {
        init0();
    }
    @PostConstruct
    public void init() throws Exception {
        init0();
        monitor.start();
    }
    private void init0(){
        properties = new Properties();
        try {
            properties.load(resource.getInputStream());
        } catch (IOException e) {
            LOGGER.error("" , e);
        }
    }
    public String get(String key){
        return properties.getProperty(key);
    }
}