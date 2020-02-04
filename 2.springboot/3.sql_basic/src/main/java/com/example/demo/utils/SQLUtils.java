package com.example.demo.utils;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SQLUtils {
    private static Logger log = LoggerFactory.getLogger(SQLUtils.class);
    
    public static Properties readProperties(String xmlFileName) {
        var properties = new Properties();
        var is = SQLUtils.class.getClassLoader().getResourceAsStream(xmlFileName);
        try {
            properties.loadFromXML(is);
        } catch (IOException e) {
            log.error("Fail to load properties file:" + xmlFileName, e);
        }
        return properties;
    }
}
