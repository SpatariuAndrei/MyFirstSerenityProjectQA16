package org.fasttrack.steps;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fasttrack.pages.ShopPage;
import org.junit.Test;

public class ShopSteps extends ScenarioSteps {

    private ShopPage shopPage;

    @Step
    public void navigateToShopPage() {
        shopPage.open();
        
    }
    @Step
    public void addItemToCart() {
        shopPage.addItemToCart();

    }

    @Step
    public void addItemToCart(String itemId) {
        shopPage.addItemToCart(itemId);

    }

    @Step
    public String addRandomItemAmount(){

        return shopPage.addRandomItemToCart();
}

}