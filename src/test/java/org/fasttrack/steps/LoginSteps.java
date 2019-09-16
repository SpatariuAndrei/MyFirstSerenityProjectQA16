package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fasttrack.pages.AccountPage;
import org.fasttrack.pages.HomePage;
import org.fasttrack.pages.LoginPage;
import org.junit.Assert;

public class LoginSteps extends ScenarioSteps   {

    private AccountPage accountPage;
    private HomePage homePage;
    private LoginPage loginPage;

    @Step
    public void navigateToLoginPage(){
        homePage.open();
        homePage.clickAccount();

    }

    @Step
    public void performLogin(String email, String pass){
        loginPage.setEmailField(email);
        loginPage.setPassField(pass);
        loginPage.clickLoginButton();
    }

    @Step
    public void  checkLoggedIn(String username){
        Assert.assertTrue("The username is not correct!",accountPage.isLoggedIn(username));
    }

    @Step
    public void checkEmailIsWrong(){
        loginPage.verifyWrongEmail();
    }

    @Step
    public void checkPasswordIsWrong () {
        loginPage.verifyWrongPassword();
}


    @Step
    public void checkUserNameIsWrong() {
        loginPage.verifyWrongUserName();

}
    @Step
    public void checkLoginWithCorectUserNameAndWrongPassword (String username) {
        loginPage.verifyLoginWithUserNameAndWrongPassword(username);


    }
}
