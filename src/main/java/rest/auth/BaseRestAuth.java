package rest.auth;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import config.PropertiesLoader;
import io.restassured.response.Response;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import rest.dto.UserLoginData;
import rest.specifications.Specifications;

import static io.restassured.RestAssured.given;

@Data
@Builder
@Slf4j
public class BaseRestAuth {
    private static String authToken;

    public static String getAuthToken() {
        if (authToken == null) {
            initialize();
        }
        return authToken;
    }

    private synchronized static void initialize() {
        // Использование класса PropertiesLoader для загрузки свойств
        String userLogin = PropertiesLoader.getProperty("user-email");
        String userPass = PropertiesLoader.getProperty("user-pass");
        authenticate(userLogin, userPass);
    }

    private static void authenticate(String userEmail, String userPassword) {
        Response response = given()
                .spec(Specifications.requestSpecification())
                .auth()
                .preemptive()
                .basic(userEmail, userPassword)
                .body(UserLoginData
                        .builder()
                        .email(userEmail)
                        .password(userPassword)
                        .build())
                .post();

        if (response.getStatusCode() != 200) {
            log.error("Authentication failed: {}", response.getStatusLine());
            log.debug("Request details : [email: {}, password: {}]", userEmail, userPassword);
        } else {
            JsonObject responseBody = JsonParser.parseString(response.getBody().asString()).getAsJsonObject();
            authToken = responseBody.get("token").getAsString();
            log.info("Authentication successful");
        }
    }
}
