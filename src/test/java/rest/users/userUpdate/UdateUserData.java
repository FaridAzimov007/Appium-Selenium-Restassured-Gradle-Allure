package rest.users.userUpdate;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import rest.dto.userUpdate.UserUpdateRequest;
import rest.dto.userUpdate.UserUpdateResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static rest.endpoints.RequestResources.SINGLE_USER_PATH;
import static rest.steps.users.UserUpdate.fileToObject;
import static rest.steps.users.UserUpdate.mappingToClass;

@DisplayName("Update user info")
public class UdateUserData {
    @Owner("Farid Azimov - SDET")
    @Feature(value = "Update user info")
    @DisplayName("Update user Name and Job")
    @Description("Verifying the updating the user Name and Job.")
    @Link(name = "JIRA Ticket", type = "jira", url = "https://your.jira.instance/browse/TICKET-Gamarjoba")
    @Tag("Smoke")
    @Test
    public void updateUserNameAndJob() {
        UserUpdateRequest updateRequest = fileToObject("src/test/resources/updateUser.json", UserUpdateRequest.class);
        Response response = mappingToClass("reqresIn-base-url", SINGLE_USER_PATH, updateRequest);
        UserUpdateResponse updateResponse = fileToObject("src/test/resources/updateUserResponse.json", UserUpdateResponse.class);
        assertEquals(updateRequest.getName(), updateResponse.getName());
        assertEquals(200, response.getStatusCode());

    }
}
