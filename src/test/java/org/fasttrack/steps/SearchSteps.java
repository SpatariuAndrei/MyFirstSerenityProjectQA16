package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fasttrack.pages.AccountPage;
import org.fasttrack.pages.HomePage;
import org.fasttrack.pages.LoginPage;
import org.fasttrack.pages.SearchResultsPage;
import org.junit.Assert;



public class SearchSteps extends ScenarioSteps {

    private HomePage homePage;
    private SearchResultsPage searchPage;

    @Step
    public void navigateToHomePage(){
        homePage.open();


    }

    @Step
    public void typeTextIntoSearchBar (String text) {
        searchPage.clickSearchButton();
        searchPage.typeIntoSearchBar(text);


    }

    @Step
    public void performSearch () {
        searchPage.setPerformSearch();


    }
    @Step
    public void checkIfTextIsFoundInSearchList (String searchValue){
        Assert.assertTrue("not all elements contain search word" ,searchPage.checkIfTextIsFoundInSearchList(searchValue));


}
    @Step
    public void checkNoResultsAreDisplayed (){
    searchPage.checkNoResultsAreDisplayed();

}
}