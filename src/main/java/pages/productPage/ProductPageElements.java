package pages.productPage;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class ProductPageElements {
    public static final By PRODUCT_PAGE_TITLE = By.xpath("//android.widget.TextView[@text='PRODUCTS']");
    public static final By PRODUCT_PRICE = AppiumBy.accessibilityId("test-Price");
    public static final By PRODUCT_TITLE_LOCATOR = By.xpath("//android.widget.TextView[@content-desc='test-Item title' and @text='Sauce Labs Backpack']");
    public static final By ITEM_PRICE = By.xpath("//android.widget.TextView[@text='Sauce Labs Backpack']/following-sibling::android.view.ViewGroup//android.widget.TextView[@content-desc='test-Price']");
    public static final By ADD_TO_CART_LOCATOR = By.xpath("//android.view.ViewGroup[@content-desc='test-Item'][.//android.widget.TextView[@text='Sauce Labs Backpack']]//android.view.ViewGroup[@content-desc='test-ADD TO CART']");
    public static final By CART_BUTTON = AppiumBy.accessibilityId("test-Cart");

}
