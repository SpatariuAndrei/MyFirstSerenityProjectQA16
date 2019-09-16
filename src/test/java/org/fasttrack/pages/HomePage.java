package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa3.fasttrackit.org:8008/")
public class HomePage extends PageObject {

    @FindBy(css = "a[title=\"Login\"]")
    private WebElementFacade accountLink;


    public void clickAccount(){
        clickOn(accountLink);
    }


    }



