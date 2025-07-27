package pages.checkoutOverview;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class CheckoutOverviewPageElements {
    public static final By PRODUCT_PRICE_OVERVIEW = By.xpath("//android.view.ViewGroup[@content-desc='test-Price']//android.widget.TextView");
    public static final By PRODUCT_TITLE_OVERVIEW = By.xpath("//android.widget.TextView[@text='Sauce Labs Backpack']");
    public static final By PRODUCT_TOTAL_PRICE = By.xpath("//android.widget.TextView[@text='Total: $32.39']");
    public static final By CHECKOUT_OVERVIEW_TITLE = By.xpath("//android.widget.TextView[@text='CHECKOUT: OVERVIEW']");
    public static final By FINISH_PAYMENT_BUTTON = AppiumBy.accessibilityId("test-FINISH");
}
