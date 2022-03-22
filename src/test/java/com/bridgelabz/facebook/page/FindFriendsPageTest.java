package com.bridgelabz.facebook.page;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bridgelabz.facebook.base.BaseClass;


public class FindFriendsPageTest extends BaseClass {
    LoginPage loginPage;
    Homepage homepage;
    FriendsPage friendsPage;

    public FindFriendsPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        homepage = new Homepage();
        homepage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
        friendsPage = homepage.clickOnFindFriendsLink();
    }

    @Test(priority = 1)
    public void verifyFriendsPageTitleTest() {
        friendsPage.verifyFriendsPageTitle();
    }

    @Test(priority = 2)
    public void ClickOnFriendRequestLinkTest() {
        friendsPage.clickOnFriendRequestLink();
    }

    @Test(priority = 3)
    public void ClickOnSuggestionsLinkTest() {
        friendsPage.clickOnSuggestionsLink();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
