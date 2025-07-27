package pages.loginPage;

import config.PropertiesLoader;
import driver.MobileDriverManager;
import helpers.CommonMobileActions;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.productPage.ProductPageSteps;

import static config.PropertiesLoader.getProperty;
import static pages.loginPage.LoginPageElements.*;

@Slf4j
public class LoginPageSteps {
    private final CommonMobileActions actions = new CommonMobileActions();

    @Step("Logging in with valid credentials using keys: {usernameKey} / {passwordKey}")
    public ProductPageSteps loginWithValidCredentials(String usernameKey, String passwordKey) {

        actions.type(USER_NAME_INPUT, getProperty(usernameKey));
        actions.type(USER_PASSWORD_INPUT, getProperty(passwordKey));
        actions.click(USER_LOGIN_BUTTON);

        log.info("Login performed successfully. Navigating to Product Page.");
        return new ProductPageSteps();
    }

    public LoginPageSteps loginWithInvalidCredentials(String usernameKey, String passwordKey) {
        String username = getProperty(usernameKey);
        String password = getProperty(passwordKey);

        actions.type(USER_NAME_INPUT, username == null ? "" : username);
        actions.type(USER_PASSWORD_INPUT, password == null ? "" : password);
        actions.click(USER_LOGIN_BUTTON);
        actions.click(USER_LOGIN_BUTTON);

        log.info("Login with invalid credentials attempted");
        return this;
    }

    @Step("Verifying login failed with expected error: {expectedMessage}")
    public LoginPageSteps verifyLoginUnsuccessful(String expectedMessage) {
        log.info("Verifying unsuccessful login with expected message: " + expectedMessage);

       actions.getText(ERROR_MESSAGE_TEXT);

        return this;
    }
}
