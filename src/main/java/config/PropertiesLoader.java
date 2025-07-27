package config;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class PropertiesLoader {
    private static final Properties properties = new Properties();

    static{
        try (InputStream inputStream = PropertiesLoader.class.getClassLoader().getResourceAsStream("projectResources.properties")){
            if (inputStream == null) {
                log.error("Configuration file 'projectResources.properties' not found in the classpath.");
                throw new IllegalStateException("Configuration file not found!");
            }
            properties.load(inputStream);
        } catch (IOException e) {
            log.error("Failed to load properties from 'projectResources.properties'.", e);
            throw new RuntimeException("Failed to load configuration properties!", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
