package org.fasttrack.features;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.RandomStringUtils;
import org.fasttrack.steps.RegisterSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)

public class RegisterTest extends PageObject {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Before
    public void maximiseWindow () { driver.manage().window().maximize();
    }

    @Steps
    private RegisterSteps registerSteps;


    private String existingUserEmail = "blabla@yahoo.com";
    private String userName = RandomStringUtils.randomAlphanumeric(20);
    private String userEmail = userName + "@yahoo.com";
    private String userPassword = "parolaandrei1234";

    @Test
    public void validRegisterTest() {
        registerSteps.navigateToRegisterPage();
        registerSteps.performRegister(userEmail,userPassword);
        registerSteps.checkRegisterIsSuccesfull(userName);

    }
    @Test
    public void invalidRegisterTest(){
        registerSteps.navigateToRegisterPage();
        registerSteps.performRegister(existingUserEmail,userPassword);
        registerSteps.verifyEmailIsDuplicated();
    }
}