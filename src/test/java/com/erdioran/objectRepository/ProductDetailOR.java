package com.erdioran.objectRepository;

import org.openqa.selenium.By;

public class ProductDetailOR {

    public static final By FAVOURITE_ICON_CSS = By.cssSelector(".product-card__fav.add-to-favorites");

    public static final By ADD_TO_BASKET_CSS = By.cssSelector(".action-btn-text1.active");

    public static final By PRODUCT_SIZE_AVAILABLE_CSS = By.cssSelector(".product-size-selector [class='button-reset ']");
    public static final By PRODUCT_NAME_CN= By.className("product-card__name");

    public static final By PRODUCT_PRICE_CSS = By.cssSelector(".product-card__right .product-card__price--new");
}
