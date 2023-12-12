package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCartClick;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currencyTabClick;


    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'£Pound Sterling')]")
    WebElement poundSterlingClick;

    public void shoppingCartClick() {
        clickOnElement(shoppingCartClick);
    }

    //currency tab click
    public void clickOnCurrencyTab() {
        clickOnElement(currencyTabClick);
    }
    public void clickOnPoundSterling() {
        clickOnElement(poundSterlingClick);
    }
}
