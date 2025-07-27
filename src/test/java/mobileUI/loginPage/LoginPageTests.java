package mobileUI.loginPage;

import base.BaseMobileTest;
import driver.AppiumDriverFactory;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Epic;
import io.qameta.allure.Link;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import pages.loginPage.LoginPageSteps;
import pages.productPage.ProductPageSteps;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("Login Page Tests")
@Epic(value = "Auth")
public class LoginPageTests extends BaseMobileTest {

    static Stream<Arguments> loginTestData() {
        return Stream.of(
                arguments("user-login", "user-password", true, null),
                arguments("non-existent-user", "user-password", false, "Epic sadface: Username and password do not match any user in this service"),
                arguments("user-login", "wrong-password", false, "Epic sadface: Username and password do not match any user in this service"),
                arguments("empty", "wrong-password", false, "Epic sadface: Username is required"),
                arguments("user-login", "empty", false, "Epic sadface: Password is required"),
                arguments("empty", "empty", false, "Epic sadface: Username is required")
        );
    }

    @ParameterizedTest(name = "[{index}] Login: {1}/{2}, expect success: {3}")
    @MethodSource("loginTestData")
    @DisplayName("Parameterized login test for valid and invalid data")
    @Description("Parameterized login test covers valid and invalid credentials as well as scenarios with empty fields and verify the correctness of the error text.")
    @Link(name = "JIRA Ticket", type = "jira", url = "https://your.jira.instance/browse/TICKET-123")
    @Tag("Smoke")
    public void loginTest(String usernameKey, String passwordKey, boolean expectSuccess, String expectedErrorMessage) {

        if (expectSuccess) {
            new LoginPageSteps()
                    .loginWithValidCredentials(usernameKey, passwordKey)
                    .verifyProductPageOpened();
        } else {
            new LoginPageSteps()
                    .loginWithInvalidCredentials(usernameKey, passwordKey)
                    .verifyLoginUnsuccessful(expectedErrorMessage);
        }
    }

}
