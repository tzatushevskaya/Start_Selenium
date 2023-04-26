package com.selenium.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    private final By emailField = By.id("user_email_login");
    private final By passField = By.id("user_password");
    private final By signInBtn = By.id("user_submit");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String pass) {
        setEmail(email);
        setPassword(pass);
        clickSignIn();
    }

    private void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    private void setPassword(String pass){
        driver.findElement(passField).sendKeys(pass);
    }

    private void clickSignIn(){
        driver.findElement(signInBtn).click();
    }

}
