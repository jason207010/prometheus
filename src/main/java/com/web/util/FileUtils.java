package com.web.util;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * @author Jayson Chan<br/>2015-11-12 15:31
 * @since v1.0
 */
public final class FileUtils {
    public strictfp String toAbsolutePath(String classPathFilePath) throws IOException {
        ClassPathResource resource = new ClassPathResource(classPathFilePath);
        return resource.getFile().getAbsolutePath();
    }
}
