package com.selenium.workshop.smadshop.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CatalogProduct extends Product {

    private WebElement name;
    private WebElement price;

    public CatalogProduct(WebElement productEl) {
        name = productEl.findElement(By.cssSelector(".name span"));
        price = productEl.findElement(By.className("price_cart"));
    }

    @Override
    protected WebElement getNameEl() {
        return name;
    }

    @Override
    protected WebElement getPriceEl() {
        return price;
    }
}
