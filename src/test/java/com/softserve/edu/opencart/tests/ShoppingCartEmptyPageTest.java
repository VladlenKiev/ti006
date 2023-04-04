package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.pages.HomePage;
import com.softserve.edu.opencart.pages.ShoppingCartEmptyPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartEmptyPageTest extends TestRunnerFirst {

    public static final String SHOPPING_CART_URL = "http://taqc-opencart.epizy.com/index.php?route=checkout/cart";
    public static final String SHOPPING_CART = "Shopping Cart";
    public static final String YOUR_SHOPPING_CART_IS_EMPTY = "Your shopping cart is empty!";
    public static final String CONTINUE = "Continue";

    @Test
    public void checkShoppingCartButtonOnHomePage() {
        // Steps
        HomePage homePage = loadApplication();
        presentationSleep();
        //
        // Check
        Assert.assertEquals(homePage.getSlideshow0FirstImageAttributeAltText(), HomePage.EXPECTED_IPHONE_6);
        Assert.assertTrue(homePage.getSlideshow0FirstImageAttributeSrcText().contains(HomePage.EXPECTED_IPHONE6));
        Assert.assertTrue(homePage.getShoppingCardButtonText("href").contains(SHOPPING_CART_URL));
    }

    @Test
    public void checkRedirectToShoppingCartPageFromHomePage() {
        // Steps
        HomePage homePage = loadApplication();
        presentationSleep();
        homePage.getShoppingCardButton().click();
        presentationSleep();
        ShoppingCartEmptyPage shoppingCartEmptyPage = loadShoppingCartEmptyPage();
        //
        // Check
        Assert.assertEquals(shoppingCartEmptyPage.getLabelShoppingCart().getText(), SHOPPING_CART);
        Assert.assertEquals(shoppingCartEmptyPage.getLabelShoppingCartIsEmpty().getText(), YOUR_SHOPPING_CART_IS_EMPTY);
        Assert.assertEquals(shoppingCartEmptyPage.getButtonContinue().getText(), CONTINUE);
    }

    @Test
    public void clickContinueOnShoppingCartPageReturnToHomePage() {
        // Steps
        HomePage homePage = loadApplication();
        presentationSleep();
        homePage.getShoppingCardButton().click();
        presentationSleep();
        ShoppingCartEmptyPage shoppingCartEmptyPage = loadShoppingCartEmptyPage();
        presentationSleep();
        shoppingCartEmptyPage.getButtonContinue().click();
        presentationSleep();
        HomePage homePageRedirect = loadApplication();
        //
        // Check
        Assert.assertEquals(homePageRedirect.getSlideshow0FirstImageAttributeAltText(), HomePage.EXPECTED_IPHONE_6);
        Assert.assertTrue(homePageRedirect.getSlideshow0FirstImageAttributeSrcText().contains(HomePage.EXPECTED_IPHONE6));
        Assert.assertTrue(homePageRedirect.getShoppingCardButtonText("href").contains(SHOPPING_CART_URL));
    }
}
