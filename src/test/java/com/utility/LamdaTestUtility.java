package com.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LamdaTestUtility {

	public static final String HUB_URL = "https://hub.lambdatest.com/wd/hub";
	private static ThreadLocal<WebDriver> driverlocal = new ThreadLocal<WebDriver>();
	private static ThreadLocal<DesiredCapabilities> capabilitiesLocal = new ThreadLocal<DesiredCapabilities>();

	public static WebDriver initializeLamdaTestSession(String browser, String testName) {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("browserVersion", "latest");
		Map<String, Object> ltOptions = new HashMap<>();
		ltOptions.put("user", "Lambda Test UserName");
		ltOptions.put("accessKey", "Lambda Test Token");
		ltOptions.put("build", "Selenium 4");
		ltOptions.put("name", testName);
		ltOptions.put("platformName", "Windows 10");
		ltOptions.put("seCdp", true);
		ltOptions.put("selenium_version", "latest");
		capabilities.setCapability("LT:Options", ltOptions);
		capabilitiesLocal.set(capabilities);
		WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL(HUB_URL), capabilitiesLocal.get());
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}

		driverlocal.set(driver);

		return driverlocal.get();

	}
	
	public static void quitSession() {
		
		if(driverlocal.get()!=null) {
			driverlocal.get().quit();
		}
	}

}

