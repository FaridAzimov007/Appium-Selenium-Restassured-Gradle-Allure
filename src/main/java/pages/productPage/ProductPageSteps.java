package pages.productPage;

import helpers.CommonMobileActions;
import io.qameta.allure.Step;
import pages.cartPage.CartPageSteps;
import pages.header.HeaderSteps;

import static pages.productPage.ProductPageElements.*;

public class ProductPageSteps {
    private final CommonMobileActions actions = new CommonMobileActions();
    private final HeaderSteps header = new HeaderSteps();
    private String productPrice;
    private String productTitle;

    @Step("Verifying Product Page opened after login")
    public boolean verifyProductPageOpened() {
        return actions.isVisible(PRODUCT_PAGE_TITLE);
    }

    @Step("Add product to cart adn proceed to Cart")
    public CartPageSteps addProductToCartAndGoToCart() {
        productTitle = actions.getText(PRODUCT_TITLE_LOCATOR);
        productPrice = actions.getText(PRODUCT_PRICE);
        actions.click(ADD_TO_CART_LOCATOR);
        header.verifyCartBadge(1);
        actions.click(CART_BUTTON);
        return new CartPageSteps(productTitle, productPrice);
    }

    @Step("Adding product to cart and verifying the count of cart badge")
    public void verifyAddingProductToCart() {
        verifyProductPageOpened();
        actions.click(ADD_TO_CART_LOCATOR);
        header.verifyCartBadge(1);
    }

}
