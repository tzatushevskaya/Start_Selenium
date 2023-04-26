package com.selenium.tutorial;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class JSAlert {

    @Test
    public void validateAlerts() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        if (buttons.size() == 3) {
            buttons.get(2).click();
            Thread.sleep(1000);
        }

        Alert alert = driver.switchTo().alert();

        String actualText = alert.getText();
        System.out.println(actualText);

        alert.sendKeys("Hello there!");
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(4000);

        driver.quit();

        assertEquals("Alert text not as expected", "I am a JS prompt", actualText);
    }
}
