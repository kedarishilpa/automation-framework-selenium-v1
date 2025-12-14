package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LamdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {
	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLamdaTest;

	@Parameters({ "browser", "isLamdaTest", "isHeadless" })
	@BeforeMethod(description = "Load homepage of the application")
	public void setup(String browser, boolean isLamdaTest, boolean isHeadless, ITestResult result) {
		WebDriver lamdaDriver;
		this.isLamdaTest = isLamdaTest;
		if (isLamdaTest) {

			lamdaDriver = LamdaTestUtility.initializeLamdaTestSession(browser, result.getMethod().getMethodName());
			homePage = new HomePage(lamdaDriver);
		} else {
			// Running the test on local machine
			logger.info("Load homepage of the application");
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
		}

	}

	public BrowserUtility getInstance() {
		return homePage;

	}

	@AfterMethod(description = "Load homepage of the application")
	public void tearDown() {
		logger.info("closing the broswer session");
		if (isLamdaTest) {
			LamdaTestUtility.quitSession();
		}

		homePage.quit(); // local

	}
}
