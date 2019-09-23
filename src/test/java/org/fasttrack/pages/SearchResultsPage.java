package org.fasttrack.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class SearchResultsPage extends PageObject {

    @FindBy(css =".search-btn")
private WebElementFacade searchButton;

    @FindBy(css= ".search-field")
    private WebElementFacade searchBar;

    @FindBy (css = ".search-block .search-submit")
    private WebElementFacade performSearchButton;

    @FindBy (css = ".no-results.not-found")
    private WebElementFacade noResultsMessage;



    public void clickSearchButton(){
        clickOn(searchButton);

    }

    public void typeIntoSearchBar (String text) {

        typeInto(searchBar, text);


    }

    public void setPerformSearch () {
        clickOn(performSearchButton);


}
    public boolean checkIfTextIsFoundInSearchList(String textSearch){

        List<WebElement> searchList = getDriver().findElements(By.cssSelector("a[rel= bookmark]"));
        if(searchList.size()<1){
            return false;
        }


        for (WebElement element:searchList) {

        element.getText().contains(textSearch);
        if (!element.getText().contains(textSearch)){
            return false;

        }

    }

        return true;
}

public boolean checkNoResultsAreDisplayed(){
        return noResultsMessage.containsText("Sorry, but nothing matched your search terms.");



    }




}