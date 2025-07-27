package pages.checkoutCompletePage;

import helpers.CommonMobileActions;
import io.qameta.allure.Step;

import static pages.checkoutCompletePage.CheckoutCompletePageElements.CHECKOUT_COMPLETE_MESSAGE;

public class CheckoutCompletePageSteps {
    private final CommonMobileActions actions = new CommonMobileActions();

    @Step("Verify the message of successful checkout completion")
    public void verifySuccessfulCheckoutMessage() {
        actions.isVisible(CHECKOUT_COMPLETE_MESSAGE);
    }

}
