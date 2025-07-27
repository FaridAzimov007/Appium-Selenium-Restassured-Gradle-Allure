package mobileUI.productPage;

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
import pages.productPage.ProductPageSteps;

import static config.PropertiesLoader.getProperty;

@DisplayName("Product Page Tests")
@Epic(value = "Product Page")
public class ProductPageTests extends BaseMobileTest {

    @Tag("Smoke")
    @Owner("Farid Azimov - SDET")
    @Feature(value = "Products")
    @Description("This test verifying that after adding product to cart the cart badge appear with correct value")
    @DisplayName("Add product to the cart and verify that the cart badge appears")
    @Link(name = "JIRA Ticket", type = "jira", url = "https://your.jira.instance/browse/TICKET-123")
    @Test
    public void verifyAddingProductToCart() {
        new LoginPageSteps()
                .loginWithValidCredentials("user-login", "user-password")
                .verifyAddingProductToCart();
    }

}
