package org.fasttrack.features;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.steps.SearchSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;



@RunWith(SerenityRunner.class)
public class SearchTest extends PageObject {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Before
    public  void maximiseWindow(){
        driver.manage().window().maximize();
    }

@Steps
private SearchSteps searchSteps;


private String searchValue = "Bag";

@Test
public void verifySearch (){
    searchSteps.navigateToHomePage();
    searchSteps.typeTextIntoSearchBar(searchValue);
    searchSteps.performSearch();
    searchSteps.checkIfTextIsFoundInSearchList(searchValue);


}

// this test will fail - search Bag
@Test
public void verifyInvalidSearch (){
    searchSteps.navigateToHomePage();
    searchSteps.typeTextIntoSearchBar(searchValue);
    searchSteps.performSearch();
    searchSteps.checkIfTextIsFoundInSearchList("Bags");
}
@Test
    public void verifyNoResultsDisplayed() {

    searchSteps.navigateToHomePage();
    searchSteps.typeTextIntoSearchBar("fqsdfsd");
    searchSteps.performSearch();
    searchSteps.checkNoResultsAreDisplayed();
    }
}