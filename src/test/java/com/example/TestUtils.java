package com.example;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import static java.nio.charset.StandardCharsets.UTF_8;

public final class TestUtils {
    private TestUtils() {
    }

    public static String readFrom(String path) throws IOException {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:" + path);
        Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8);
        return FileCopyUtils.copyToString(reader);
    }
}
