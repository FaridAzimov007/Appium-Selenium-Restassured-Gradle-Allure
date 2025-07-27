package rest.users.userInfo;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import rest.dto.userInfo.singleUser.SingleUserResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static rest.endpoints.RequestResources.SINGLE_USER_EMAIL;
import static rest.endpoints.RequestResources.SINGLE_USER_PATH;
import static rest.mappers.FileMapper.mappingGetRequestToObjectWithoutParams;

@DisplayName("Get user info")
public class UserInfoTests {

    @Owner("Farid Azimov - SDET")
    @Feature(value = "Getting user info")
    @DisplayName("Get single user info")
    @Description("Obtaining information data of single user")
    @Link(name = "JIRA Ticket", type = "jira", url = "https://your.jira.instance/browse/TICKET-Gamarjoba")
    @Tag("REstApi")
    @Test
    public void getSingleUser() {
        SingleUserResponse singleUserResponse = mappingGetRequestToObjectWithoutParams("reqresIn-base-url", SINGLE_USER_PATH, SingleUserResponse.class);
        assertEquals(SINGLE_USER_EMAIL, singleUserResponse.getData().getEmail());
    }
}
