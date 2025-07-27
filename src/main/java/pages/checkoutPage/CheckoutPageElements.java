package pages.checkoutPage;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class CheckoutPageElements {
    public static final By FIRST_NAME_INPUT = AppiumBy.accessibilityId("test-First Name");
    public static final By LAST_NAME_INPUT = AppiumBy.accessibilityId("test-Last Name");
    public static final By ZIP_CODE_INPUT = AppiumBy.accessibilityId("test-Zip/Postal Code");
    public static final By CONTINUE_BUTTON = AppiumBy.accessibilityId("test-CONTINUE");
    public static final By CHECKOUT_INFO_LOCATOR = AppiumBy.accessibilityId("test-Checkout: Your Info");
}
