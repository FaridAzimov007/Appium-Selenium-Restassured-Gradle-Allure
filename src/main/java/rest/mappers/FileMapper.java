package rest.mappers;

import io.qameta.allure.Step;
import rest.client.GetRequest;

public class FileMapper {
    @Step("Get to object")
    public static <T> T mappingGetRequestToObjectWithParams(String url, String path, String param, Class<T> dto) {
        return new GetRequest().getRequestWithPathAndParams(url, path, param, dto);

    }

    @Step("Get to object")
    public static <T> T mappingGetRequestToObjectWithoutParams(String url, String path, Class<T> dto) {
        return new GetRequest().getRequestWithPath(url, path, dto);

    }
}
