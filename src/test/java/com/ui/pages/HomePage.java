package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LocatorFactory;

public final class HomePage extends BrowserUtility {

    private static final String PAGE = "homePage";
    private By signInLink = LocatorFactory.getBy(PAGE, "signInLink");

    // Only constructor needed
    public HomePage(WebDriver driver) {
        super(driver);
        goToWebsite(JSONUtility.getEnvironment().getURL());
    }

    public LoginPage goToLoginPage() {
        clickOn(signInLink);
        return new LoginPage(getDriver());
    }
}
