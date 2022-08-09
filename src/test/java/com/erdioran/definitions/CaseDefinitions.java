package com.erdioran.definitions;


import com.erdioran.base.DriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.erdioran.base.Common.*;
import static com.erdioran.base.Common.getProductPrice;
import static com.erdioran.base.Page.click;
import static com.erdioran.base.Page.hoverToElement;
import static com.erdioran.objectRepository.BasketPageOR.*;
import static com.erdioran.objectRepository.CategoryOR.*;
import static com.erdioran.objectRepository.HomePageOR.*;
import static com.erdioran.objectRepository.ProductDetailOR.*;
import static com.erdioran.utils.DataManager.getData;
import static org.junit.Assert.*;

public class CaseDefinitions {

    WebDriver driver = DriverManager.getDriver();


    private static final Logger LOGGER = LogManager.getLogger(CaseDefinitions.class);

    public String productName;
    public String productPrice;


    @Given("user is on {string} page")
    public void user_is_on_defacto_com_page(String url) {
        pageLoad(getData("common." + url));
        LOGGER.info("user is redirect to " + url + " page");

    }

    @Then("check home page load")
    public void check_home_page_load() {

        boolean displayed = driver.findElement(BASKET_CSS).isDisplayed();
        assertTrue(displayed);
        LOGGER.info("home page load");

    }

    @Then("check product detail page load")
    public void check_product_detail_page_load() {

        boolean displayed = driver.findElement(FAVOURITE_ICON_CSS).isDisplayed();
        assertTrue(displayed);
        LOGGER.info("product detail page load");

    }

    @Then("check basket page load")
    public void check_basket_page_load() {

        boolean displayed = driver.findElement(COMPLATE_ORDER_BUTTON_CSS).isDisplayed();
        assertTrue(displayed);
        LOGGER.info("basket page load");

    }

    @Then("check category product count")
    public void check_category_product_count() {

        assertTrue(checkProductCount(CATEGORY_PRODUCT_COUNT_CSS) > 0);
        LOGGER.info("category product > 0");

    }

    @And("click {string}")
    public void click_x(String by) {

        click(By.xpath("//a[@title='" + by + "']"));
        LOGGER.info("click " + by);

    }

    @And("choose {string} size in filter")
    public void choose_size_filter_category(String size) {

        chooseSizeFilter(size);
        LOGGER.info("choose size " + size);

    }

    @And("click random product")
    public void click_random_product() {
        int product=randomProductSelectInCategoryPage();

        LOGGER.info("click product "+product);

    }

    @And("save product name")
    public void save_product_name() {

        productName = getProductName();
        LOGGER.info("saved product name: " + productName);

    }

    @And("save product price")
    public void save_product_price() {

        productPrice = getProductPrice();
        LOGGER.info("saved product price: " + productPrice);

    }

    @And("choose random size in product detail")
    public void choose_random_size_product_detail() {

        int size=selectRandomSize();
        LOGGER.info("choose size product detail "+size);

    }

    @Then("add to basket")
    public void add_to_basket() {

        click(ADD_TO_BASKET_CSS);
        LOGGER.info("add to basket product");

    }

    @And("click basket summary")
    public void click_basket_summary() {

        click(BASKET_CSS);
        LOGGER.info("click basket summary");

    }

    @And("click go to basket")
    public void click_go_to_basket() {

        click(GO_TO_CART_CSS);
        LOGGER.info("click go to basket");

    }

    @Then("check product name")
    public void check_product_name() {

        assertEquals(productName, getText(BASKET_PAGE_PRODUCT_NAME_CN));
        LOGGER.info("checked product name");

    }

    @Then("check product price")
    public void check_product_price() {

        assertEquals(productPrice.replace("\n", " "), getText(BASKET_PAGE_PRODUCT_PRICE_CN));
        LOGGER.info("checked product price");

    }

    @When("hover over {string} category")
    public void hover_over_category(String categoryName) {

        hoverToElement(By.xpath("//a[@title='" + categoryName + "']"));
        LOGGER.info("hover over " + categoryName + " category");

    }

    @And("delete last product in basket")
    public void delete_last_product_in_basket() {

        delete_product_in_basket();
        LOGGER.info("delete last product in basket");

    }

    @Then("check basket is empty")
    public void check_basket_is_empty() {

        assertTrue(checkPageLoad(EMPTY_BASKET_TEXT_CSS));
        LOGGER.info("basket is empty");

    }


}
