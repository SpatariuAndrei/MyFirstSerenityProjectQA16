package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import java.util.List;

@DefaultUrl("http://qa3.fasttrackit.org:8008/cart")
public class CartPage extends PageObject {
    @FindBy(css = ".cart_item")
    private List<WebElementFacade> cartItems;

    @FindBy(css = ".order-total .amount")
    private WebElementFacade cartTotalAmount;

    public boolean isCartEmpty(){
        return cartItems.isEmpty();
    }

    public String getCartTotalAmout() {
        return cartTotalAmount.getText();



    }


}
