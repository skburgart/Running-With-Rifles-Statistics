package com.skburgart.rwr;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Steven Burgart <skburgart@gmail.com>
 */
public class RWRConfig {

    private static final Properties properties = loadProperties("rwr-stats.properties");

    private static Properties loadProperties(String fileName) {

        Properties props = new Properties();
        try {
            InputStream is = RWRConfig.class.getClassLoader().getResourceAsStream(fileName);
            props.load(is);
        } catch (IOException exp) {
            // Failed to laod properties
        }
        return props;
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}