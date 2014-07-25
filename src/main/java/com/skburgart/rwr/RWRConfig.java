/**
 * Copyright (c) 2014 ICRL
 * See the file license.txt for copying permission.
 */
package com.skburgart.rwr;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 *
 * @author Steven Burgart <skburgart@gmail.com>
 */
public class RWRConfig {

    private static final Logger log = Logger.getLogger(RWRConfig.class.getName());

    private static final String PROPERTIES_FILENAME = "rwr-stats.properties";
    private static final Properties properties = loadProperties(PROPERTIES_FILENAME);

    private static Properties loadProperties(String fileName) {

        Properties props = new Properties();
        try {
            log.info("Loading properties file");
            InputStream is = RWRConfig.class.getClassLoader().getResourceAsStream(fileName);
            props.load(is);
        } catch (IOException ex) {
            log.error(String.format("Failed to load properties file '%s': %s", PROPERTIES_FILENAME, ex.getMessage()));
        }
        return props;
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
