package org.fasttrack.features;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.steps.LoginSteps;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LoginTest {

    @Managed(uniqueSession = true)
    private   WebDriver driver;

    @Before
    public  void maximiseWindow(){
        driver.manage().window().maximize();
    }


    @Steps
    private LoginSteps loginSteps;



    private String userEmail = "spatariuandrei@yahoo.com";
    private String userPass = "IonuT123AndreiS";
    private String userName = "spatariuandrei";



    @Test
    public void validLoginTest() {
        loginSteps.navigateToLoginPage();
        loginSteps.performLogin(userEmail, userPass);
        loginSteps.checkLoggedIn(userName);

    }

    @Test
    public void invalidLoginWithWrongEmailTest() {
        loginSteps.navigateToLoginPage();
        loginSteps.performLogin("dddd@yahoo.com", "aaaaaaaaa");
        loginSteps.checkEmailIsWrong();
    }
    @Test
    public void invalidLoginWithWrongPasswordTest() {
        loginSteps.navigateToLoginPage();
        loginSteps.performLogin(userEmail,"aaaaaa");
        loginSteps.checkPasswordIsWrong();

}
    @Test
        public void validLoginTestWithUserName() {
        loginSteps.navigateToLoginPage();
        loginSteps.performLogin(userName, userPass);
        loginSteps.checkLoggedIn(userName);

}
    @Test
    public void invalidLoginWithWrongUserNameTest() {
        loginSteps.navigateToLoginPage();
        loginSteps.performLogin("dddd", "aaaaaaaaa");
        loginSteps.checkUserNameIsWrong();
    }

    @Test
    public void invalidLoginWithCorectUserNameAndWrongPasswordTest() {
        loginSteps.navigateToLoginPage();
        loginSteps.performLogin(userName, "aaaaaaaaa");
        loginSteps.checkLoginWithCorectUserNameAndWrongPassword(userName);
    }
}