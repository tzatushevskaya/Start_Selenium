package com.selenium.workshop.smadshop.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchComponent {

    @FindBy(id = "filter_keyword")
    private WebElement searchInput;

    @FindBy(className = "button-search")
    private WebElement searchButton;

    public SearchComponent(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void search(String searchTerm) {
        searchInput.sendKeys(searchTerm);
        searchButton.click();
    }
}
