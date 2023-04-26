package com.selenium.page_object;

import com.selenium.utils.PageLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryLoginPage {

    private final WebDriver driver;
    private final By loginBlock = By.className("auth-form-tablet");

    @FindBy(id = "user_email_login")
    @CacheLookup
    private WebElement emailField;

    @FindBy(id = "user_password")
    @CacheLookup
    private WebElement passField;

    @FindBy(id = "user_submit")
    @CacheLookup
    private WebElement signInBtn;

    public PageFactoryLoginPage(WebDriver driver) {
        this.driver = driver;
        new PageLoader(this.driver).isElementPresent(loginBlock);
        PageFactory.initElements(this.driver, this);
    }

    public void login(String email, String pass) {
        emailField.sendKeys(email);
        passField.sendKeys(pass);
        signInBtn.click();
    }

}
