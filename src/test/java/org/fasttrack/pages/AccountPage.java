package org.fasttrack.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://fasttrackit.org/selenium-test/customer/account/")
public class AccountPage extends PageObject {

    @FindBy(css = ".woocommerce-MyAccount-content")
    private WebElementFacade helloText;

    public boolean isLoggedIn(String userName){
        return helloText.containsText(userName);
    }

}
