package mobileUI.cartPage;

import base.BaseMobileTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.loginPage.LoginPageSteps;

@DisplayName("Cart Page Tests")
@Epic(value = "Cart Page")
public class CartPageTests extends BaseMobileTest {

    @Tag("Smoke")
    @Owner("Farid Azimov - SDET")
    @Feature(value = "Cart")
    @Description("This test verifying that after adding product to cart the cart badge appear with correct value, then navigate to cart and validate product title and price matching with Product page")
    @DisplayName("Add product to cart and validate title, price, and cart badge")
    @Link(name = "Ticket-1234", type = "jira", url = "https://your.jira.instance/browse/TICKET-123")
    @Test
    public void verifyingProductDataMatchingInCart() {
        new LoginPageSteps()
                .loginWithValidCredentials("user-login", "user-password")
                .addProductToCartAndGoToCart()
                .verifyProductData();

    }

    @Tag("Smoke")
    @Owner("Farid Azimov - SDET")
    @Feature(value = "Cart")
    @Description("This test verifies that after removing a product from the cart, the cart badge displays the correct value and the product container is removed.")
    @DisplayName("Remove product from cart and validate product container removal and cart badge")
    @Link(name = "Ticket-1234", type = "jira", url = "https://your.jira.instance/browse/TICKET-123")
    @Test
    public void verifyingProductRemovalFromCart() {
        new LoginPageSteps()
                .loginWithValidCredentials("user-login", "user-password")
                .addProductToCartAndGoToCart()
                .verificationRemoveProductFromCart();

    }

}
