package rest.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import static io.restassured.RestAssured.given;
import static rest.auth.BaseRestAuth.getAuthToken;
import static rest.specifications.Specifications.requestSpecification;

@Slf4j
public class PostRequest {
    private Gson GSON = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();

    @Step("Post request without dto class")
    public Response postRequestToPathWithoutDto(String url, String path, Object body) {

        return given(requestSpecification())
                .log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", getAuthToken())
                .body(GSON.toJson(body))
                .post(RestRequest.generateURIWithoutParam(url, path));

    }

    @Step("Post request with dto class to path")
    public <T> T postRequestToPath(String url, String path, Object body, Class<T> dto) {
        Response response = given(requestSpecification())
                .log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", getAuthToken())
                .body(GSON.toJson(body))
                .post(RestRequest.generateURIWithoutParam(url, path));
        log.info("Response Result {}", response.getBody().print());
        return response.as(dto);

    }

}
