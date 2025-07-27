package pages.header;

import helpers.CommonMobileActions;

import static pages.header.HeaderElements.CART_BADGE;

public class HeaderSteps {
    private final CommonMobileActions actions = new CommonMobileActions();

    public void verifyCartBadge(int expected) {
        String badge = actions.getText(CART_BADGE);
        int actual = Integer.parseInt(badge);
        if (actual != expected) {
            throw new AssertionError("Expected badge: " + expected + ", but got: " + actual);
        }
    }
}
