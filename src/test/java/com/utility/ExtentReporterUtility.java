package com.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterUtility {
	
	 
	private static ExtentReports extentReports;
	private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	
	public static void setupSparkReporter(String reportName) {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH-mm-ss");
		
		String reportFilePath=System.getProperty("user.dir") + File.separator+"test-output"+ File.separator+"ExtentReports"+ File.separator;
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(reportFilePath+ reportName+"_"+dateFormat.format(date)+".html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
	}
	
	public static void createExtentTest(String testName) {
		ExtentTest test=extentReports.createTest(testName);
		extentTest.set(test);
	}

	public static ExtentTest getTest() {
		return extentTest.get();
		
	}
	
	public static void flushReport() {
		extentReports.flush();
	}
}
