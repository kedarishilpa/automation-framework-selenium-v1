package com.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;

public class DriverFactory {
	
	
	  private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	    private DriverFactory() {
	        // Prevent object creation
	    }

	    public static WebDriver getDriver() {
	        return driver.get();
	    }

	    public static void initDriver(Browser browser, boolean isHeadless) {

	        switch (browser) {

	        case CHROME:
	            ChromeOptions chromeOptions = new ChromeOptions();
	            if (isHeadless) {
	                chromeOptions.addArguments("--headless=new");
	                chromeOptions.addArguments("--window-size=1920,1080");
	                chromeOptions.addArguments("--disable-gpu");
	            }
	            driver.set(new ChromeDriver(chromeOptions));
	            break;

	        case EDGE:
	            EdgeOptions edgeOptions = new EdgeOptions();
	            if (isHeadless) {
	                edgeOptions.addArguments("--headless=new");
	                edgeOptions.addArguments("--window-size=1920,1080");
	            }
	            driver.set(new EdgeDriver(edgeOptions));
	            break;

	        case FIREFOX:
	            FirefoxOptions firefoxOptions = new FirefoxOptions();
	            if (isHeadless) {
	                firefoxOptions.addArguments("--headless");
	                firefoxOptions.addArguments("--width=1920");
	                firefoxOptions.addArguments("--height=1080");
	            }
	            driver.set(new FirefoxDriver(firefoxOptions));
	            break;

	        default:
	            throw new IllegalArgumentException("Invalid browser: " + browser);
	        }
	    }
	    
	    
	    public static void initDriver(String browserName) {
			if (browserName.equalsIgnoreCase("chrome")) {

				driver.set(new ChromeDriver());
			}
			if (browserName.equalsIgnoreCase("edge")) {
				driver.set(new EdgeDriver());
			} else {
				throw new IllegalArgumentException("Invalid browser: " + browserName);
			}
		}

	    public static void quitDriver() {
	        if (driver.get() != null) {
	            driver.get().quit();
	            driver.remove();
	        }
	    }

}
