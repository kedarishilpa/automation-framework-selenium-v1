package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;

public abstract class BrowserUtility {

    protected WebDriver driver;
    Logger logger = LoggerUtility.getLogger(this.getClass());

    // Constructor Injection (IMPORTANT)
    public BrowserUtility(WebDriver driver) {
        this.driver = driver;
        logger.info("BrowserUtility initialized with driver instance");
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void goToWebsite(String url) {
    	maximizeWindow();
    	logger.info("Navigating to URL: {}", url);
        driver.get(url);
    }

    public void maximizeWindow() {
        logger.info("Maximizing browser window");
        driver.manage().window().maximize();
    }

    public void clickOn(By locator) {
        logger.info("Clicking on element: {}", locator);
        driver.findElement(locator).click();
    }

    public void setText(By locator, String text) {
        logger.info("Setting text '{}' in element: {}", text, locator);
        driver.findElement(locator).sendKeys(text);
    }

    public String getText(By locator) {
        logger.info("Getting text from element: {}", locator);
        String text = driver.findElement(locator).getText();
        logger.info("Text retrieved: {}", text);
        return text;
    }

    public String takeScreenshot(String name) {
        logger.info("Capturing screenshot: {}", name);

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "./screenshots/" + name + "_" + timeStamp() + ".png";

        try {
            FileUtils.copyFile(src, new File(path));
            logger.info("Screenshot saved at: {}", path);
        } catch (IOException e) {
            logger.error("Failed to save screenshot", e);
        }

        return path;
    }

    private String timeStamp() {
        return new SimpleDateFormat("HH-mm-ss").format(new Date());
    }
}
