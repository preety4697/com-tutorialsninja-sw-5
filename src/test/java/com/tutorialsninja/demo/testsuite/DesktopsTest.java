package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.DesktopsPage;
import com.tutorialsninja.demo.pages.ShoppingCartPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import com.tutorialsninja.demo.testdata.TestData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DesktopsTest extends BaseTest {
    DesktopsPage desktopsPage ;
    ShoppingCartPage shoppingcartPage ;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        desktopsPage = new DesktopsPage();
        shoppingcartPage = new ShoppingCartPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyProductArrangeInAlphaBaticalOrder() {
        //1.1 Mouse hover on Desktops Tab.and click
        desktopsPage.mouseHoverAndClickDesktops();
        //1.2 Click on “Show All Desktops”
        desktopsPage.clickOnShowAllDeskTops();
        //1.3 Select Sort By position "Name: Z to A"
        desktopsPage.selectSortByZToA();
        //1.4 Verify the Product will arrange in Descending order.
        desktopsPage.verifyProductArrangeInDescendingOrder();
    }

    @Test(groups = {"smoke", "regression"}, dataProvider = "credentials", dataProviderClass = TestData.class)

    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        //2.1 Mouse hover on Desktops Tab. and click
        desktopsPage.mouseHoverAndClickDesktops();
        // 2.2 Click on “Show All Desktops”
        desktopsPage.clickOnShowAllDeskTops();
        //2.3 Select Sort By position "Name: A to Z"
        desktopsPage.selectSortByAToZ();
        // 2.4 Select product “HP LP3065”
        desktopsPage.selectProduct();
        // 2.5 Verify the Text "HP LP3065"
        Assert.assertEquals(desktopsPage.getHPText(), "HP LP3065", "HP LP3065 Product not display");
        // 2.6 Select Delivery Date "2023-11-30"
        desktopsPage.selectDeliveryDate();
        //2.7.Enter Qty "1” using Select class.
        //  desktopPage.enterQty();
        // 2.8 Click on “Add to Cart” button
        waitUntilVisibilityOfElementLocated(By.id("input-option225"), 5);
        desktopsPage.addToCart();
        // 2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        Assert.assertEquals(desktopsPage.getSuccessMessageText(), "Success: You have added HP LP3065 to your shopping cart!\n" + "×", "Product not added to cart");
        //  2.10 Click on link “shopping cart” display into success message
        shoppingcartPage.shoppingCartClick();
        //  2.11 Verify the text "Shopping Cart"
        Assert.assertEquals(desktopsPage.getShoppingCartText(), "Shopping Cart  (1.00kg)", "Shopping cart not displayed");
        //change the currency to  £ sterling
        shoppingcartPage.clickOnCurrencyTab();
        shoppingcartPage.clickOnPoundSterling();
        //  2.12 Verify the Product name "HP LP3065"
        Assert.assertEquals(desktopsPage.getHPProductText(), "HP LP3065", "HP LP3065 not displayed");
        //  2.13 Verify the Delivery Date "2023-11-30"
        Assert.assertEquals(desktopsPage.getDeliveryDateText(), "Delivery Date:2023-11-30", "2023-11-30 not displayed");
        //  2.14 Verify the Model "Product21"
        Assert.assertEquals(desktopsPage.getProduct21Text(), "Product 21", "product21 not displayed");
        //  2.15 Verify the Todal "£74.73"
        Assert.assertEquals(desktopsPage.getTotalCostText(), "£74.73", "total not matched");
    }
}
