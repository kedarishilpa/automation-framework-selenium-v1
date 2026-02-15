package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;
import com.utility.LocatorFactory;

public final class MyAccountPage extends BrowserUtility{
	
	 private static final String PAGE = "myAccountPage";
	    private By userNameText = LocatorFactory.getBy(PAGE, "userNameText");

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	public String getUserName() {
		String userName=getText(userNameText);
		
		return userName;
		
	}
}
