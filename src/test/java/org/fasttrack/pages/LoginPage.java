package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa3.fasttrackit.org:8008/my-account")
public class LoginPage extends PageObject {

    @FindBy(css = "#username")
    private WebElementFacade typeEmailField;

    @FindBy(css = "#password")
    private WebElementFacade passwordField;

    @FindBy(css = "[value=Login]")
    private WebElementFacade loginButton;

    @FindBy(css = ".woocommerce-error")
    private WebElementFacade errorMessageSpan;

    public void setEmailField(String email) {
        typeInto(typeEmailField, email);
    }

    public void setPassField(String pass) { typeInto(passwordField, pass);

    }

    public void clickLoginButton(){
        clickOn(loginButton);
    }

    public boolean verifyWrongEmail(){
      return errorMessageSpan.containsText("Invalid email address.");
    }
    public boolean verifyWrongPassword(String email) {
       return errorMessageSpan.containsText("The password you entered for the email address " + email +   " is incorrect.");

    }
    public boolean verifyWrongUserName(){
      return   errorMessageSpan.containsText("Invalid username.");

}
    public boolean verifyLoginWithUserNameAndWrongPassword(String username) {
       return errorMessageSpan.containsText("The password you entered for the username " + username +  " is incorrect. ");

    }
}