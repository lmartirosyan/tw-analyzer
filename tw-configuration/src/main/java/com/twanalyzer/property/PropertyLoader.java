package com.twanalyzer.property;

import com.twanalyzer.enums.StreamPropertyFile;
import com.twanalyzer.wrapper.LoggerWrapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public  class  PropertyLoader {

    private static LoggerWrapper logger = LoggerWrapper.getInstance();;


    /**
     * Loads properties frm specified resource file
     *
     * @return
     */
    public static Properties loadStreamProperties(StreamPropertyFile streamPropertyFile) {

        return loadProperties( streamPropertyFile.get());
    }

    /**
     *
      * @param propertyFile
     * @return
     */
    public static Properties loadProperties(String propertyFile) {
        Properties properties = new Properties();
        try (InputStream inputStream = PropertyLoader.class.getClassLoader().getResourceAsStream(propertyFile)) {
            properties.load(inputStream);

        } catch (IOException e) {
            logger.error("property file is not found: " + propertyFile,e);
        }
        return properties;
    }
}
