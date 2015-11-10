package com.web.config;

import com.web.common.Reloadable;
import org.apache.commons.io.filefilter.NameFileFilter;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * @author Jayson Chan<br/>2015-11-09 16:03
 * @since v1.0
 */
public abstract class ReloadableConfig extends FileAlterationListenerAdaptor implements Reloadable {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReloadableConfig.class);

    public ReloadableConfig() {
        new Thread(()->{
            long interval = TimeUnit.SECONDS.toMillis(30);
            try {
                ClassPathResource resource = new ClassPathResource(getClassPathFilePath());
                File file = resource.getFile();
                FileAlterationObserver observer = new FileAlterationObserver(file.getParentFile() , new NameFileFilter(file.getName()));
                observer.addListener(this);
                FileAlterationMonitor monitor = new FileAlterationMonitor(interval , observer);
                monitor.start();
            } catch (Exception e) {
                LOGGER.error("ClassPathFilePath:{}" , getClassPathFilePath());
                LOGGER.error("" , e);
            }
        }).start();
    }

    protected abstract String getClassPathFilePath();

    @Override
    public void onFileChange(File file) {
        reload();
    }
}
