package com.bridgelabz.facebook.page;

import com.bridgelabz.facebook.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.html.HTMLInputElement;

public class Homepage extends BaseClass {
    @FindBy(xpath = "//span[contains(text(),'Aniket Budhbaware')]")

    WebElement userProfile;

    @FindBy(xpath = "//span[contains(text(),'Find Friends')]")
    WebElement friendsLink;

    @FindBy(xpath = "//span[contains(text(),'Saved')]")
    WebElement savedLink;
    private HTMLInputElement userProfileLink;

    public Homepage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyHomePageTitle() {
        return driver.getTitle();
    }

    public ProfilePage clickOnProfile() {

        userProfile.click();
        return new ProfilePage();
    }

    public FriendsPage clickOnFriendsLink() {
        friendsLink.click();
        return new FriendsPage();
    }

    public SavedPage clickOnSavedLink() {
        savedLink.click();
        return new SavedPage();
    }

    public FriendsPage clickOnFindFriendsLink() {

        friendsLink.click();
            return new FriendsPage();
    }
}
