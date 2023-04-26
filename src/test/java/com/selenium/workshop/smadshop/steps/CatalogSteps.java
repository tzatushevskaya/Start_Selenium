package com.selenium.workshop.smadshop.steps;

import com.selenium.workshop.smadshop.component.CatalogProduct;
import com.selenium.workshop.smadshop.dto.ProductDto;
import com.selenium.workshop.smadshop.page.CatalogPage;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.Assert.assertTrue;

public class CatalogSteps {

    private final CatalogPage catalogPage;

    public CatalogSteps(WebDriver driver) {
        catalogPage = new CatalogPage(driver);
    }

    public void checkResultListIsPresent() {
        List<CatalogProduct> productList = catalogPage.getProductList();
        assertThat(productList).as("the product list is empty").hasSizeGreaterThan(0);
        assertTrue("the product list is empty", productList.size() > 0);
    }

    public void checkTermIsPresentInResults(String searchTerm) {
        for (CatalogProduct product : catalogPage.getProductList()) {
            assertTrue("the product name doesn't contain " + searchTerm,
                    product.getName().contains(searchTerm));
        }
    }

    public int getRandomProductIndex() {
        return new Random().nextInt(catalogPage.getProductList().size());
    }

    public ProductDto getProductDetails(int productIndex) {
        return new ProductDto(catalogPage.getProductList().get(productIndex));
    }

    public void openProduct(int productIndex) {
        catalogPage.openItem(productIndex);
    }
}
