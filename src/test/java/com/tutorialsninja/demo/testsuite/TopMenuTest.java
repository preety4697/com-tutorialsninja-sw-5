package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TopMenuTest extends BaseTest {
    HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
    }

    @Test(groups = {"sanity","smoke", "regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //1.1 Mouse hover on “Desktops” Tab and click
        homePage.mouseHoverAndClickDesktops();
        //1.2 call selectMenu method and pass the menu = “Show AllDesktops”
        homePage.selectMenu("Show AllDesktops");
        //1.3 Verify the text ‘Desktops’
        Assert.assertEquals(homePage.getDesktopText(), "Desktops", "Desktops text not found");
    }

    @Test(groups = {"smoke","regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        homePage.mouseHoverAndClickLaptopsAndNotebooks();
        //2.2 call selectMenu method and pass the menu = “Show AllLaptops & Notebooks”
        homePage.selectMenu("Show AllLaptops & Notebooks");
        //2.3 Verify the text ‘Laptops & Notebooks’
        Assert.assertEquals(homePage.getLaptopsNotebooksText(), "Laptops & Notebooks", "Laptops and Notebooks text not found");

    }

    @Test(groups = {"regression"})
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        //3.1 Mouse hover on “Components” Tab and click
        homePage.mouseHoverAndClickComponents();
        //3.2 call selectMenu method and pass the menu = “Show AllComponents”
        homePage.selectMenu("Show AllComponents");
        //3.3 Verify the text ‘Components’
        Assert.assertEquals(homePage.getComponents(), "Components", "Components not found");
    }
}
