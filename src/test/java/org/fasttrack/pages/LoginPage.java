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

    public void verifyWrongEmail(){
        errorMessageSpan.shouldContainText("Invalid email address.");
    }
    public void verifyWrongPassword() {
        errorMessageSpan.shouldContainText("The password you entered for the email address spatariuandrei@yahoo.com is incorrect.");

    }
    public void verifyWrongUserName(){
        errorMessageSpan.shouldContainText("Invalid username.");

}
    public void verifyLoginWithUserNameAndWrongPassword(String username) {
        errorMessageSpan.shouldContainText("The password you entered for the username " + username +  " is incorrect. ");

    }
}