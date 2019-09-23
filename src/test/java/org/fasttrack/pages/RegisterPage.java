package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa3.fasttrackit.org:8008/")

public class RegisterPage extends PageObject {



@FindBy(css= "a[title=\"Login\"]")
private WebElementFacade accounlink ;


@FindBy(css = "#reg_email")
    private WebElementFacade registerEmailField;

@FindBy(css = "#reg_password")
    private WebElementFacade registerPasswordField;

@FindBy (css = ".register .woocommerce-Button")
private WebElementFacade registerButton;

@FindBy(css = ".woocommerce-error")
 private WebElementFacade registerErrorMessage;

public void setRegisterEmailField(String emailField) {
    typeInto(registerEmailField,emailField);
}


public void setPasswordField(String passwordField){
    typeInto(registerPasswordField,passwordField);
}


public void clickRegisterButton (){clickOn(registerButton);
}

public boolean verifyEmailIsInUse() {
return registerErrorMessage.containsText("Error: An account is already registered with your email address. Please log in.");



}
}