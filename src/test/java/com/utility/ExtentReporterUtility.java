package com.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterUtility {

    private static ExtentReports extentReports;
    private static final ThreadLocal<ExtentTest> extentTest =
            new ThreadLocal<>();

    // 🔹 Thread-safe initialization
    public synchronized static void setupSparkReporter(String reportName) {

        if (extentReports != null) {
            return; // Prevent re-initialization
        }

        String timestamp =
                new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss")
                        .format(new Date());

        String reportDir = System.getProperty("user.dir")
                + File.separator + "test-output"
                + File.separator + "ExtentReports";

        File dir = new File(reportDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        ExtentSparkReporter sparkReporter =
                new ExtentSparkReporter(
                        reportDir + File.separator
                                + reportName + "_" + timestamp + ".html");

        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
    }

    public static void createExtentTest(String testName) {
        if (extentReports == null) {
            throw new IllegalStateException(
                    "ExtentReports not initialized. "
                    + "Call setupSparkReporter() first.");
        }

        ExtentTest test = extentReports.createTest(testName);
        extentTest.set(test);
    }

    public static ExtentTest getTest() {
        return extentTest.get();
    }

    // Clean ThreadLocal after each test
    public static void removeTest() {
        extentTest.remove();
    }

    public synchronized static void flushReport() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }
}
