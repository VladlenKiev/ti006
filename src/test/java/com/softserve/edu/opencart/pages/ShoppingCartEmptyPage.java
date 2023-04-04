package com.softserve.edu.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartEmptyPage extends TopPart{

    private WebElement labelShoppingCart;
    private WebElement labelShoppingCartIsEmpty;
    private WebElement buttonContinue;

    public ShoppingCartEmptyPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        labelShoppingCart = driver.findElement(By.cssSelector("#content > h1"));
        labelShoppingCartIsEmpty = driver.findElement(By.cssSelector("#content > p"));
        buttonContinue = driver.findElement(By.linkText("Continue"));
    }

    protected ShoppingCartEmptyPage loadApplication() {
        return new ShoppingCartEmptyPage(driver);
    }

    public WebElement getLabelShoppingCart() {
        return labelShoppingCart;
    }

    public WebElement getLabelShoppingCartIsEmpty() {
        return labelShoppingCartIsEmpty;
    }

    public WebElement getButtonContinue() {
        return buttonContinue;
    }
}
