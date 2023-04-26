package com.selenium.ui_test;

import com.selenium.page_object.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    private static WebDriver driver;

    private static final String EMAIL = "test@example.com";
    private static final String PASS = "my_password";
    private static final String URL = "https://www.browserstack.com/users/sign_in";

    @BeforeClass
    public static void setUp() {
        System.out.println("Setting web driver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @AfterClass
    public static void tearDown(){
        System.out.println("Closing the driver");
        driver.quit();
    }

    @Test
    public void loginTest() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
//        PageFactoryLoginPage loginPage = new PageFactoryLoginPage(driver);
        loginPage.login(EMAIL, PASS);
//        Thread.sleep(2000);
    }
}
