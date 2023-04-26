package com.selenium.workshop.smadshop.steps;

import com.selenium.workshop.smadshop.dto.ProductDto;
import com.selenium.workshop.smadshop.page.ProductPage;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class ProductDetailsSteps {

    private final ProductPage productPage;

    public ProductDetailsSteps(WebDriver driver) {
        productPage = new ProductPage(driver);
    }

    public void checkProductPageLoaded() {
        assertTrue("the product page is not loaded", productPage.isPageLoaded());
    }

    public ProductDto getProductDetails() {
        return new ProductDto(productPage.getProduct());
    }
}
