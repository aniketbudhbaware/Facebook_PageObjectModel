package com.bridgelabz.facebook.page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bridgelabz.facebook.base.BaseClass;

public class FriendsPage extends BaseClass {
    @FindBy(xpath = "//span[contains(text(),'Friend requests')]")
    WebElement findFriendsLink;

    @FindBy(xpath = "//span[contains(text(),'Suggestions')]")
    WebElement suggestionsLink;

    @FindBy(xpath = "//span[contains(text(),'All Friends')]")
    WebElement allFriendsLink;


    //Initializing the Page Objects:
    public FriendsPage() {
        PageFactory.initElements(driver, this);
    }
    public String verifyFriendsPageTitle() {

        return driver.getTitle();
    }
    public FriendRequestsPage clickOnFriendRequestLink() {
        findFriendsLink.click();
        return new FriendRequestsPage();
    }
    public SuggestionsPage clickOnSuggestionsLink() {
        suggestionsLink.click();
        return new SuggestionsPage();
    }


}
