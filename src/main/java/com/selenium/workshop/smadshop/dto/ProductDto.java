package com.selenium.workshop.smadshop.dto;

import com.selenium.workshop.smadshop.component.CatalogProduct;
import com.selenium.workshop.smadshop.component.DetailedProduct;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class ProductDto {

    private String description;
    private int price;

    public ProductDto(CatalogProduct catalogProduct){
        setDescription(catalogProduct.getName());
        setPrice(catalogProduct.getPrice());
    }

    public ProductDto(DetailedProduct detailedProduct){
        setDescription(detailedProduct.getName());
        setPrice(detailedProduct.getPrice());
    }

}