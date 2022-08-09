package com.erdioran.objectRepository;

import org.openqa.selenium.By;


public class BasketPageOR {



    public static final By COMPLATE_ORDER_BUTTON_CSS = By.cssSelector("#summaryCompletedButton");
    public static final By BASKET_PAGE_PRODUCT_NAME_CN = By.className("shopping-product-card__info--title");

    public static final By BASKET_PAGE_PRODUCT_PRICE_CN= By.className("shopping-product-card__info--price-new");

    public static final By BASKET_PAGE_DELETE_PRODUCT_CSS = By.cssSelector(".mr-2.hidden-sm-down");

    public static final By DELETE_BUTTON_POPUP_CSS = By.cssSelector(".button.button--border.button--medium.delete-button.mt-3");

    public static final By EMPTY_BASKET_TEXT_CSS = By.cssSelector(".shopping__empty--title");



}
