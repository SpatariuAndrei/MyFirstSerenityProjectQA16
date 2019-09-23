package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

@DefaultUrl("http://qa3.fasttrackit.org:8008/shop")

public class ShopPage extends PageObject {

    @FindBy(css = ".purchasable")
    private List<WebElementFacade> shopItemList;


    @FindBy(css = ".add_to_cart_button")
    private WebElementFacade addToCarButton;

    @FindBy(css = "ins .amount")
    private WebElementFacade itemAmount;

    @FindBy(css = ".added")
    private WebElementFacade addedItemSign;



    public void addItemToCart() {
        addToCarButton.click();
        waitFor(addedItemSign);

    }

    public void addItemToCart(String itemId) {
        findBy(".add_to_cart_button[data-product_id = '"+ itemId + "']").click();
    }

    public String addRandomItemToCart () {
        int size = shopItemList.size();
        int randomIndex = (int)(Math.random() * size);
        WebElement item = shopItemList.get(randomIndex);
        String amount = item.findElement(By.cssSelector("ins .amount")).getText();
        item.findElement(By.cssSelector(".add_to_cart_button")).click();

        return amount;

    }
}
