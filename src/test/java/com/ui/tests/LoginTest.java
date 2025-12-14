package com.ui.tests;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest extends TestBase {

	@Test(enabled = true, description = "Verify with valid user is able to login to appln", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void loginTest(User user) {

		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Shilpa Kedari");

	}

	@Test(enabled = false, description = "Verify with valid user is able to login to appln", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider")
	public void loginCSVTest(User user) {

		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Shilpa Kedari");

	}

	@Test(enabled = false, description = "Verify with valid user is able to login to appln", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void loginExcelTest(User user) {

		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Shilpa Kedari");

	}

	/*
	 * @AfterTest public void closeBroswer() { closeBroswer(); }
	 */

}
