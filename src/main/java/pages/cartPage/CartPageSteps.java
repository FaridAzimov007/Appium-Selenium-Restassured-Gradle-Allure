package pages.cartPage;

import helpers.CommonMobileActions;
import io.qameta.allure.Step;
import pages.checkoutPage.CheckoutPageSteps;
import pages.header.HeaderSteps;

import static pages.cartPage.CartPageElements.*;
import static pages.checkoutOverview.CheckoutOverviewPageElements.*;
import static pages.header.HeaderElements.CART_BADGE;

public class CartPageSteps {

    private final CommonMobileActions actions = new CommonMobileActions();
    private final HeaderSteps header = new HeaderSteps();
    private final String expectedTitle;
    private final String expectedPrice;

    public CartPageSteps(String expectedTitle, String expectedPrice) {
        this.expectedTitle = expectedTitle;
        this.expectedPrice = expectedPrice;
    }

    @Step("Verify productTitle in Cart")
    public CartPageSteps verifyProductData() {
        String actualTitle = actions.getText(PRODUCT_TITLE_IN_CART);
        String actualPrice = actions.getText(PRODUCT_PRICE_IN_CART);
        actions.isVisible(PRODUCT_TOTAL_PRICE);

        if (!actualTitle.equals(expectedTitle)) {
            throw new AssertionError("Expected title: " + expectedTitle + ", but got: " + actualTitle);
        }

        if (!actualPrice.equals(expectedPrice)) {
            throw new AssertionError("Expected price: " + expectedPrice + ", but got: " + actualPrice);
        }

        return this;
    }

    @Step("Validate product data and go to checkout")
    public CheckoutPageSteps validateProductDataAndGoToCheckout() {
        actions.isVisible(CART_TITLE);
        verifyProductData();
        actions.click(CHECKOUT_BUTTON);

        return new CheckoutPageSteps(expectedTitle, expectedPrice);
    }

    @Step("Removing a product from the basket and checking that there is no product card")
    public CartPageSteps verificationRemoveProductFromCart() {
        actions.isVisible(PRODUCT_ITEM_CONTAINER);
        actions.click(REMOVE_BUTTON);
        actions.isNotVisible(PRODUCT_ITEM_CONTAINER);
        actions.isNotVisible(CART_BADGE);

        return this;
    }





}
