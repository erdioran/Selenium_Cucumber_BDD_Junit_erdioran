package com.erdioran.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.erdioran.objectRepository.BasketPageOR.*;
import static com.erdioran.objectRepository.CategoryOR.*;
import static com.erdioran.objectRepository.ProductDetailOR.*;

public class Common extends Page {


    public static void pageLoad(String url) {

        DriverManager.getDriver().get(url);


    }


    public static boolean checkPageLoad(By by) {

        boolean displayed = DriverManager.getDriver().findElement(by).isDisplayed();
        return displayed;

    }

    public static int checkProductCount(By by) {

        int count = Integer.parseInt(DriverManager.getDriver().findElement(by).getText());
        return count;

    }

    public static void chooseSizeFilter(String size) {

        enterText(SEARCH_SIZE_TEXTBOX_CSS, size);
        click(By.xpath("//label[normalize-space()='" + size + "']"));

    }

    public static void chooseSizeProductDetail(String size) {

        click(By.cssSelector("button[value='" + size + "']"));

    }

    public static void delete_product_in_basket() {

        click(BASKET_PAGE_DELETE_PRODUCT_CSS);
        click(DELETE_BUTTON_POPUP_CSS);

    }

    public static int randomProductSelectInCategoryPage() {
        List<WebElement> products = waitAllElement(CATEGORY_PRODUCTS_CSS);
        int random_number = random_number(0, products.size()-1);
        click(By.xpath("(//div[@class='product-card'])[" + random_number + "]"));
        return random_number;
    }

    public static int selectRandomSize(){

        List<WebElement> size_available = waitAllElement(PRODUCT_SIZE_AVAILABLE_CSS);
        int random_number = random_number(0, size_available.size()-1);
        size_available.get(random_number).click();
        return random_number;
    }


    public static String getProductName() {

        return DriverManager.getDriver().findElement(PRODUCT_NAME_CN).getText();

    }

    public static String getProductPrice() {

        return getText(PRODUCT_PRICE_CSS);

    }


}
