package com.ui.tests;

import static org.testng.Assert.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ui.pojo.User;

@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest extends TestBase {

	@Test(enabled = true, description = "Verify with valid user is able to login to appln", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void loginTest(User user) {

		String actualUserName = homePage.goToLoginPage().doLoginWith(user).getUserName();

		assertEquals(actualUserName, user.getExpectedUserName(),
				"Username mismatch for user: " + user.getEmailAddress());

	}

	@Test(enabled = false, description = "Verify with valid user is able to login to appln", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider")
	public void loginCSVTest(User user) {

		String actualUserName = homePage.goToLoginPage().doLoginWith(user).getUserName();

		assertEquals(actualUserName, user.getExpectedUserName(),
				"Username mismatch for user: " + user.getEmailAddress());

	}

	@Test(enabled = false, description = "Verify with valid user is able to login to appln", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void loginExcelTest(User user) {
		String actualUserName = homePage.goToLoginPage().doLoginWith(user).getUserName();

		assertEquals(actualUserName, user.getExpectedUserName(),
				"Username mismatch for user: " + user.getEmailAddress());

	}

	/*
	 * @AfterTest public void closeBroswer() { closeBroswer(); }
	 */

}
