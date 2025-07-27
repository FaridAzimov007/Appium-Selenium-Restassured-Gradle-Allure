package rest.client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static rest.auth.BaseRestAuth.getAuthToken;
import static rest.specifications.Specifications.requestSpecification;

public class GetRequest {
    public <T> T getRequestWithPathAndParams(String url, String path, String param, Class<T> dto) {
        Response response = given(requestSpecification())
                .log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", getAuthToken())
                .get(RestRequest.generateURIWithParam(url, path, param));

        if (response.getStatusCode() != 200) {
            throw new AssertionError("Unexpected status code: " + response.getStatusCode());
        }

        return response.as(dto);
    }

    public <T> T getRequestWithPath(String url, String path, Class<T> dto) {
        Response response = given(requestSpecification())
                .log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", getAuthToken())
                .get(RestRequest.generateURIWithoutParam(url, path));

        if (response.getStatusCode() != 200) {
            throw new AssertionError("Unexpected status code: " + response.getStatusCode());
        }
        return response.as(dto);
    }
}
