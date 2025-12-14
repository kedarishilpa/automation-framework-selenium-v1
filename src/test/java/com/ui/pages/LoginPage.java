package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility {
	
	private static final By EMAIL_INPUT=By.id("email");
	private static final By PASSWORD_INPUT=By.id("passwd");
	private static final By SUBMIT_BUTTON=By.id("SubmitLogin");

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public MyAccountPage doLoginWith(String email, String password) {
		setText(EMAIL_INPUT, email);
		setText(PASSWORD_INPUT, password);
		clickOn(SUBMIT_BUTTON);
		
		MyAccountPage myAccountPage=new MyAccountPage(getDriver());
		return myAccountPage;
		
		
	}
}
