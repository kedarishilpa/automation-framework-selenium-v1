package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;

import static com.utility.PropertiesUtil.*;

public final class HomePage extends BrowserUtility { // page object design pattern
	WebDriver driver;
	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[@class='login']");

	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName,isHeadless);
		//readProperty(QA, "url");
		goToWebsite(JSONUtility.readJson(QA).getURL());
		
	}
	
	public HomePage(WebDriver driver) {
		super(driver); // to call the parent class constructor from the child class constructor.
		goToWebsite(JSONUtility.readJson(QA).getURL());
		
	}

	public LoginPage goToLoginPage() {
		clickOn(SIGN_IN_LINK_LOCATOR);

		LoginPage loginPage = new LoginPage(getDriver());

		return loginPage;
	}

}
