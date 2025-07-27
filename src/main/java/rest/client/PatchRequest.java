package rest.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static rest.auth.BaseRestAuth.getAuthToken;
import static rest.specifications.Specifications.requestSpecification;

public class PatchRequest {
    private Gson GSON = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();

    public Response patchRequestToPathWithoutDto(String url, String path, Object body) {

        return given(requestSpecification())
                .log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", getAuthToken())
                .body(GSON.toJson(body))
                .patch(RestRequest.generateURIWithoutParam(url, path));

    }

}
