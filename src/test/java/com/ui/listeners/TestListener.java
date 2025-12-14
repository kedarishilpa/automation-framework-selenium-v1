package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReporterUtility;
import com.utility.LoggerUtility;

public class TestListener implements ITestListener {

    private static final Logger logger =
            LoggerUtility.getLogger(TestListener.class);

    @Override
    public void onStart(ITestContext context) {
        logger.info("Test Suite Started");
        ExtentReporterUtility.setupSparkReporter("TestReport");
    }

    @Override
    public void onTestStart(ITestResult result) {
        logger.info(result.getMethod().getMethodName());
        logger.info(result.getMethod().getDescription());
        logger.info(Arrays.toString(result.getMethod().getGroups()));

        ExtentReporterUtility.createExtentTest(
                result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info(result.getMethod().getMethodName() + " : PASSED");

        ExtentReporterUtility.getTest()
                .log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error(result.getMethod().getMethodName() + " : FAILED", 
                     result.getThrowable());

        ExtentReporterUtility.getTest()
                .log(Status.FAIL, result.getThrowable());

        captureScreenshot(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn(result.getMethod().getMethodName() + " : SKIPPED");

        ExtentReporterUtility.getTest()
                .log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test Suite Completed");
        ExtentReporterUtility.flushReport();
    }

    // Utility method (safe)
    private void captureScreenshot(ITestResult result) {
        try {
            Object testInstance = result.getInstance();

            if (testInstance instanceof TestBase) {
                BrowserUtility browserUtility =
                        ((TestBase) testInstance).getInstance();

                if (browserUtility != null) {
                    String screenshotPath =
                            browserUtility.takeScreenshot(
                                    result.getMethod().getMethodName());

                    ExtentReporterUtility.getTest()
                            .addScreenCaptureFromPath(screenshotPath);
                }
            }
        } catch (Exception e) {
            logger.error("Failed to capture screenshot", e);
        }
    }
}
