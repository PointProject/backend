package com.pointproject.utils;

import java.net.URL;

public class ResourceProducer {

    public static URL getResource(String name) {
        return ResourceProducer.class.getResource(name);
    }

    public static String getResourcePath(String name) {
        return ResourceProducer.class.getResource(name)
            .getPath();
    }
}
