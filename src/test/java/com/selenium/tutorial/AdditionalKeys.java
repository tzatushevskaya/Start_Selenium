package com.selenium.tutorial;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdditionalKeys {

    @Test
    public void validateAdditionalKeys() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver =  new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/key_presses");

        driver.findElement(By.id("target")).sendKeys(Keys.LEFT);
        Thread.sleep(1000);

        driver.findElement(By.id("target")).sendKeys(Keys.chord(Keys.CONTROL, "A"));
        Thread.sleep(1000);

        driver.quit();
    }
}
