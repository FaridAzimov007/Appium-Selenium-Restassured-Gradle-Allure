package rest.steps.users;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import rest.client.PatchRequest;
import rest.client.PostRequest;

import java.io.FileReader;
import java.io.IOException;

public class UserUpdate {
    /**
     * Reading a file and mapping it to an object
     */
    public static <T> T fileToObject(String path, Class<T> dto) {
        try {
            return new Gson().fromJson(new JsonReader(new FileReader(path)), dto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Step("Mapping json to a class object")
    public static <T> T mappingToDto(String url, String path, Object body, Class<T> dto) {
        return new PostRequest().postRequestToPath(url, path, body, dto);
    }

    @Step("Mapping json to a class object")
    public static Response mappingToClass(String url, String path, Object body) {
        return new PatchRequest().patchRequestToPathWithoutDto(url, path, body);
    }
}
