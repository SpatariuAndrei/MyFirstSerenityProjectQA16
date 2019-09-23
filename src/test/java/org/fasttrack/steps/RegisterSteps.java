package org.fasttrack.steps;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fasttrack.pages.AccountPage;
import org.fasttrack.pages.HomePage;
import org.fasttrack.pages.RegisterPage;
import org.junit.Assert;

public class RegisterSteps extends ScenarioSteps {


private HomePage homePage;
private RegisterPage registerPage;
private AccountPage accountPage;

@Step
public void navigateToRegisterPage () {
    homePage.open();
    homePage.clickAccount();


}
@Step
public void performRegister (String email, String password) {
    registerPage.setRegisterEmailField(email);
    registerPage.setPasswordField(password);
    registerPage.clickRegisterButton();



}

@Step
public void checkRegisterIsSuccesfull(String userEmail){
    Assert.assertTrue("Email already in use" , accountPage.isLoggedIn(userEmail));



}
@Step
    public void verifyEmailIsDuplicated (){
   Assert.assertTrue("Duplicated email message not shown", registerPage.verifyEmailIsInUse());

}
}