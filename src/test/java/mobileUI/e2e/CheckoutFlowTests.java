package mobileUI.e2e;

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

@DisplayName("E2E Purchase flow")
@Epic(value = "Payment")
public class CheckoutFlowTests extends BaseMobileTest {

    @Tag("Smoke")
    @Owner("Farid Azimov - SDET")
    @Feature(value = "Cart")
    @Description("E2E flow: add product to cart, verify badge and details, complete checkout and confirm order")
    @DisplayName("Complete product purchase flow with cart and checkout validation")
    @Link(name = "Ticket-1234", type = "jira", url = "https://your.jira.instance/browse/TICKET-123")
    @Test
    public void purchaseProductAndValidateCartAndCheckout() {
        new LoginPageSteps()
                .loginWithValidCredentials("user-login", "user-password")
                .addProductToCartAndGoToCart()
                .validateProductDataAndGoToCheckout()
                .fillCheckoutInfoAndGoToOverview()
                .verifyProductDataProceedCheckoutComplete()
                .verifySuccessfulCheckoutMessage();
    }
}
