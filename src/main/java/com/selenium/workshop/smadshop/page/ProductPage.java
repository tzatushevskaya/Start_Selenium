package com.selenium.workshop.smadshop.page;

import com.selenium.workshop.smadshop.component.DetailedProduct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    private DetailedProduct detailedProduct;

    public ProductPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        detailedProduct = new DetailedProduct(driver);
    }

    public boolean isPageLoaded() {
        return !detailedProduct.getName().isEmpty();
    }

    public DetailedProduct getProduct() {
        return detailedProduct;
    }
}
