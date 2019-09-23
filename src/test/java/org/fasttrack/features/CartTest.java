package org.fasttrack.features;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.steps.CartSteps;
import org.fasttrack.steps.ShopSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CartTest {


    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Before
    public  void maximiseWindow(){
        driver.manage().window().maximize();
    }

    @Steps
    private ShopSteps shopSteps;

    @Steps
    private CartSteps cartSteps;


    private  String itemId1 = "2627";
    private String itemId2 = "2585";

    @Test
    public void addToCart() {
        shopSteps.navigateToShopPage();
        shopSteps.addItemToCart();
        cartSteps.navigateToCartPage();
        cartSteps.verifyCartIsNotEmpty();

    }

    @Test
    public void verifyCartTotalCost() {
        shopSteps.navigateToShopPage();
        shopSteps.addItemToCart(itemId1);
        shopSteps.addItemToCart(itemId2);
        cartSteps.navigateToCartPage();
        cartSteps.verifyCartTotalAmount("180,00 lei");

    }

    @Test
    public void verifyRandomItemAmountAddedToCart() {
        shopSteps.navigateToShopPage();
        String amount = shopSteps.addRandomItemAmount();
        cartSteps.navigateToCartPage();
        cartSteps.verifyCartTotalAmount(amount);





    }
}

