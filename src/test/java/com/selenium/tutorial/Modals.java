package com.selenium.tutorial;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Modals {

    @Test
    public void validateAlerts() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.w3schools.com/bootstrap/bootstrap_modal.asp");

        String currentWindow = driver.getWindowHandle();

        driver.findElement(By.cssSelector("button[data-toggle='modal']")).click();
        Thread.sleep(1000);

        WebElement modal = driver.findElement(By.className("modal-content"));

        for (String windowName : driver.getWindowHandles()) {
            if (!windowName.equals(currentWindow)){
                driver.switchTo().window(windowName);
                break;
            }
        }

//        modal.findElement(By.cssSelector("button[data-dismiss='modal']")).click();
        modal.findElement(By.xpath("(//button[@data-dismiss='modal'])[2]")).click();
        Thread.sleep(1000);

        driver.switchTo().window(currentWindow);

        driver.quit();
    }

}
