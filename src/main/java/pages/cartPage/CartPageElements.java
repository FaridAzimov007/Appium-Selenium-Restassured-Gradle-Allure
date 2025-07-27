package pages.cartPage;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class CartPageElements {
    public static final By CART_TITLE = By.xpath("//android.widget.TextView[@text='YOUR CART']");
    public static final By PRODUCT_TITLE_IN_CART = By.xpath("//android.widget.TextView[@text='Sauce Labs Backpack']");
    public static final By PRODUCT_PRICE_IN_CART = By.xpath("//android.view.ViewGroup[@content-desc='test-Price']//android.widget.TextView");
    public static final By CHECKOUT_BUTTON = AppiumBy.accessibilityId("test-CHECKOUT");
    public static final By REMOVE_BUTTON = AppiumBy.accessibilityId("test-REMOVE");
    public static final By PRODUCT_ITEM_CONTAINER = AppiumBy.accessibilityId("test-Item");
}
