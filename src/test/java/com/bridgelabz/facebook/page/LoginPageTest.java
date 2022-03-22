package com.bridgelabz.facebook.page;


import com.bridgelabz.facebook.base.BaseClass;
import com.bridgelabz.facebook.utility.UtilityClass;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class LoginPageTest extends BaseClass {
    LoginPage loginPage;
    Homepage homepage;
    String sheetName = "Login";
    Logger log;
    public LoginPageTest() {
        super();
        log = Logger.getLogger(LoginPageTest.class);

    }


    @BeforeMethod
    public void setUp() {
        initialization();

    }

    @Test(priority = 1)
    public void loginPageTitleTest() {
        loginPage = new LoginPage();
        String loginPageTitle = loginPage.validateLoginPageTitle();
        Assert.assertEquals(loginPageTitle, "Facebook – log in or sign up", loginPageTitle);
        log.info("Login facebook page");
    }

    @Test(priority = 2)
    public void loginTest() {
        loginPage = new LoginPage();
        homepage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
    }

    @DataProvider
    public Object[][] getLoginTestdata() {
        return UtilityClass.getTestData(sheetName);
    }

    @Test(priority = 3, dataProvider = "getLoginTestdata")
    public void loginTest(String username, String password) {
        loginPage = new LoginPage();
        homepage = loginPage.login(username, password);
        log.info("login facebook page using username and password: " + username + password);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}
