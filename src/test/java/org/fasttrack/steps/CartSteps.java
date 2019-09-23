package org.fasttrack.steps;

import net.thucydides.core.steps.ScenarioSteps;
import org.fasttrack.pages.CartPage;
import org.junit.Assert;

public class CartSteps extends ScenarioSteps {
    private CartPage cartPage;




    public void navigateToCartPage() {
        cartPage.open();
    }

    public void verifyCartIsNotEmpty() {
        Assert.assertFalse("Cart does not contain any products ", cartPage.isCartEmpty());


    }

    public void verifyCartTotalAmount(String expectedCartTotalAmount) {
            Assert.assertEquals(expectedCartTotalAmount,cartPage.getCartTotalAmout());


    }
}
