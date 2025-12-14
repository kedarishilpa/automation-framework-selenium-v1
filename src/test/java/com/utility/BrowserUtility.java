package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public WebDriver getDriver() {
		return driver.get();
	}

	/**
	 * @param driver
	 */
	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver); // inilize instance variable driver
	}

	public BrowserUtility(String browserName) {
		logger.info("Launching browser for " + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {

			driver.set(new ChromeDriver());
		}
		if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		} else {
			logger.error("invalid browser name " + browserName);
			System.out.println("invalid browser name ");
		}
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {
	    if (browserName == Browser.CHROME) {
	        ChromeOptions chromeOptions = new ChromeOptions();
	        if (isHeadless) {
	            chromeOptions.addArguments("--headless=new"); // modern headless mode
	            chromeOptions.addArguments("--window-size=1920,1080");
	            chromeOptions.addArguments("--disable-gpu");
	            chromeOptions.addArguments("--remote-allow-origins=*");
	        }
	        driver.set(new ChromeDriver(chromeOptions));
	    } else if (browserName == Browser.EDGE) {
	        EdgeOptions edgeOptions = new EdgeOptions();
	        if (isHeadless) {
	            edgeOptions.addArguments("--headless=new");
	            edgeOptions.addArguments("--window-size=1920,1080");
	            edgeOptions.addArguments("--disable-gpu");
	        }
	        driver.set(new EdgeDriver(edgeOptions));
	    } else if (browserName == Browser.FIREFOX) {
	        FirefoxOptions options = new FirefoxOptions();
	        if (isHeadless) {
	            options.addArguments("--headless");
	            options.addArguments("--width=1920");
	            options.addArguments("--height=1080");
	        }
	        driver.set(new FirefoxDriver(options));
	    } else {
	        System.out.println("Invalid browser name");
	    }
	}
	public void goToWebsite(String url) {
		logger.info("Visiting the website" + url);
		driver.get().get(url);
	}

	public void maximizeWindow() {
		logger.info("Maximizimg the Broswer Window");
		driver.get().manage().window().maximize();// maximize the window
	}

	public void clickOn(By locator) {
		logger.info("Finding Element with the loactor" + locator);
		WebElement element = driver.get().findElement(locator);

		logger.info("element found and now performimg click" + locator);
		element.click();
	}

	public void setText(By locator, String textToSet) {
		logger.info("Finding Element with the loactor" + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("element found and enter text" + textToSet);
		element.sendKeys(textToSet);
	}

	public String getText(By locator) {
		logger.info("Finding Element with the loactor" + locator);
		String text = driver.get().findElement(locator).getText();
		logger.info("element found and returning the visible " + text);
		return text;

	}

	public String takeScreenshot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		String path =  "./screenshot/" + name + "_" + getTimeStamp() + ".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
		}
		return path;
	}

	public String getTimeStamp() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH-mm-ss");
		return dateFormat.format(date);

	}

	public void quit() {

		driver.get().quit();

	}
}
