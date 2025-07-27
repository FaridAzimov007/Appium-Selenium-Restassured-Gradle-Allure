package rest.specifications;

import config.PropertiesLoader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
public class Specifications {
    private static final String BASE_URI_KEY = "reqresIn-auth-url";
    private static final String baseUri;

    static {
        baseUri = initializeBaseUri();
    }

    private static String initializeBaseUri() {
        try {
            String uri = PropertiesLoader.getProperty(BASE_URI_KEY);
            new URI(uri);
            return uri;
        } catch (URISyntaxException e) {
            log.error("The base URI in the property file is malformed: {}", e.getMessage());
            throw new IllegalArgumentException("Base URI must be a valid URI.", e);
        }
    }

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .setContentType(ContentType.JSON)
                .setRelaxedHTTPSValidation()
                .addHeader("x-api-key", "reqres-free-v1")
                .build();
    }
}
