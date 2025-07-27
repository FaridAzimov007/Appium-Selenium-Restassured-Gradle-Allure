package pages.checkoutOverview;

import helpers.CommonMobileActions;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import pages.checkoutCompletePage.CheckoutCompletePageSteps;

import static pages.checkoutOverview.CheckoutOverviewPageElements.*;

public class CheckoutOverviewPageSteps {

    private final CommonMobileActions actions = new CommonMobileActions();
    private final String expectedTitle;
    private final String expectedPrice;

    public CheckoutOverviewPageSteps(String expectedTitle, String expectedPrice) {
        this.expectedTitle = expectedTitle;
        this.expectedPrice = expectedPrice;
    }

    @Step("Verify product title")
    public CheckoutOverviewPageSteps verifyProductData() {
        String actualTitle = actions.getText(PRODUCT_TITLE_OVERVIEW);
        String actualPrice = actions.getText(PRODUCT_PRICE_OVERVIEW);
        actions.isVisible(PRODUCT_TOTAL_PRICE);

        if (!actualTitle.equals(expectedTitle)) {
            throw new AssertionError("Expected title: " + expectedTitle + ", but got: " + actualTitle);
        }

        if (!actualPrice.equals(expectedPrice)) {
            throw new AssertionError("Expected price: " + expectedPrice + ", but got: " + actualPrice);
        }

        return this;
    }

    @Step("Validate product data and go to Checkout Complete")
    public CheckoutCompletePageSteps verifyProductDataProceedCheckoutComplete() {
        actions.isVisible(CHECKOUT_OVERVIEW_TITLE);
        verifyProductData();
        actions.swipeUp(200);
        actions.click(FINISH_PAYMENT_BUTTON);

        return new CheckoutCompletePageSteps();

    }
}
