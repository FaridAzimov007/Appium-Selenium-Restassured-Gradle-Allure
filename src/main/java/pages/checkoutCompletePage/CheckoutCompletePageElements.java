package pages.checkoutCompletePage;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class CheckoutCompletePageElements {
    public static final By CHECKOUT_COMPLETE_MESSAGE = By.xpath("//android.widget.TextView[@text='CHECKOUT: COMPLETE!']");
    public static final By BACK_HOME_BUTTON = AppiumBy.accessibilityId("test-BACK HOME");
}
