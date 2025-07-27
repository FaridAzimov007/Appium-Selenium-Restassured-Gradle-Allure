package rest.client;

import config.PropertiesLoader;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
public class RestRequest {
    public static URI generateURIWithParam(String propertyUrlName, String path, String params) {
        try {
            // Получаем базовый URL из PropertiesLoader
            String baseUrl = PropertiesLoader.getProperty(propertyUrlName);
            if (baseUrl == null) {
                log.error("Property for URL '{}' not found", propertyUrlName);
                throw new IllegalArgumentException("Property for URL not found: " + propertyUrlName);
            }

            // Формируем полный URI
            return new URI(baseUrl + path + "?" + params);
        } catch (URISyntaxException e) {
            throw new RuntimeException("Error forming URI", e);
        }
    }

    public static URI generateURIWithoutParam(String propertyUrlName, String path) {
        try {
            // Получаем базовый URL из PropertiesLoader
            String baseUrl = PropertiesLoader.getProperty(propertyUrlName);
            if (baseUrl == null) {
                throw new IllegalArgumentException("Property for URL not found: " + propertyUrlName);
            }

            // Формируем полный URI
            return new URI(baseUrl + path);
        } catch (URISyntaxException e) {
            throw new RuntimeException("Error forming URI", e);
        }
    }
}
