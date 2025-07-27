package pages.checkoutPage;

import helpers.CommonMobileActions;
import io.qameta.allure.Step;
import pages.checkoutOverview.CheckoutOverviewPageSteps;

import static config.PropertiesLoader.getProperty;
import static pages.checkoutPage.CheckoutPageElements.*;

public class CheckoutPageSteps {
    private final CommonMobileActions actions = new CommonMobileActions();
    private final String expectedTitle;
    private final String expectedPrice;

    public CheckoutPageSteps(String expectedTitle, String expectedPrice) {
        this.expectedTitle = expectedTitle;
        this.expectedPrice = expectedPrice;
    }

    @Step("Fill checkoit info and continue")
    public CheckoutOverviewPageSteps fillCheckoutInfoAndGoToOverview() {
        actions.isVisible(CHECKOUT_INFO_LOCATOR);
        actions.type(FIRST_NAME_INPUT, getProperty("user-name"));
        actions.type(LAST_NAME_INPUT, getProperty("user-lastName"));
        actions.type(ZIP_CODE_INPUT, getProperty("zip-postal-code"));
        actions.click(CONTINUE_BUTTON);

        return new CheckoutOverviewPageSteps(expectedTitle, expectedPrice);
    }

}
