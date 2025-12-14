package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.User;
import com.ui.tests.TestData;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;

public class LoginDataProvider {

	@DataProvider(name = "LoginTestDataProvider")
	public Iterator<Object[]> loginDataProvider() throws FileNotFoundException {
		Gson json = new Gson();

		String path = System.getProperty("user.dir") + File.separator + "testData" + File.separator + "logindata.json";

		File testDataFile = new File(path);

		if (!testDataFile.exists()) {
			throw new RuntimeException("Test data file not found: " + path);
		}
		try (FileReader fileReader = new FileReader(testDataFile);){
			

			TestData testData = json.fromJson(fileReader, TestData.class);

			List<Object[]> dataToReturn = new ArrayList<Object[]>();
			for (User user : testData.getData()) {

				dataToReturn.add(new Object[] { user });

			}

			return dataToReturn.iterator();

		} catch (Exception e) {
			throw new RuntimeException("Failed to read login test data", e);
		}
	}

	@DataProvider(name = "LoginTestCSVDataProvider")
	public Iterator<User> loginCSVDataProvider() {

		return CSVReaderUtility.readCSVFile("loginData.csv");

	}

	@DataProvider(name = "LoginTestExcelDataProvider")
	public Iterator<User> loginExcelDataProvider() {

		return ExcelReaderUtility.readExcelFile("loginData.xlsx");

	}

}
