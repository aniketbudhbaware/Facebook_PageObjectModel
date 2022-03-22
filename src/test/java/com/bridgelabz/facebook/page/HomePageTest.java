package com.bridgelabz.facebook.page;

import com.bridgelabz.facebook.base.BaseClass;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {
    LoginPage loginPage;
    Homepage homePage;
    ProfilePage profilePage;
    FriendsPage friendsPage;
    SavedPage savedPage;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        homePage = new Homepage();
        homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));

    }

    @Test(priority = 1)
    public void verifyHomePageTitle() {
        homePage.verifyHomePageTitle();
    }

    @Test(priority = 2)
    public void verifyClickOnProfileTest() {
        profilePage = homePage.clickOnProfile();
    }

    @Test(priority = 3)
    public void verifyFriendsPageTest() {
        friendsPage = homePage.clickOnFriendsLink();
    }

    @Test(priority = 4)
    public void verifySavedPageTest() {
        savedPage = homePage.clickOnSavedLink();
    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
