package com.selenium.tutorial;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class InteractingWithCheckboxes {

    @Test
    public void checkCheckbox() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver =  new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkBox = driver.findElement(By.tagName("input"));
        checkBox.click();
        Thread.sleep(5000);

        driver.navigate().to("https://formy-project.herokuapp.com/checkbox");

        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
        System.out.println("Number of webElements with tag input found: " + checkboxes.size());
        Thread.sleep(1000);
        for (WebElement c: checkboxes) {
            c.click();
            Thread.sleep(500);
        }
        Thread.sleep(1000);
        for (WebElement c: checkboxes) {
            c.click();
            Thread.sleep(500);
        }
        driver.quit();

    }
}
