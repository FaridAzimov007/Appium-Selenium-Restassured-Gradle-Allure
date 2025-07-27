package pages.loginPage;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class LoginPageElements {
    public static final By USER_NAME_INPUT = AppiumBy.accessibilityId("test-Username");
    public static final By USER_PASSWORD_INPUT = AppiumBy.accessibilityId("test-Password");
    public static final By USER_LOGIN_BUTTON = AppiumBy.accessibilityId("test-LOGIN");
    public static final By ERROR_MESSAGE_CONTAINER = MobileBy.AccessibilityId("test-Error message");
    public static final By ERROR_MESSAGE_TEXT = By.xpath("//android.view.ViewGroup[@content-desc='test-Error message']/android.widget.TextView");}
