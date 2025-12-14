package com.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import com.ui.pojo.User;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CSVReaderUtility {

	public static Iterator<User> readCSVFile(String fileName) {

		File csvFile = new File(System.getProperty("user.dir") + File.separator + "testData"+ File.separator + fileName);
		FileReader fileReader = null;
		CSVReader csvReader = null;
		String[] line;
		List<User> userlist = null;
		User userData;

		try {
			fileReader = new FileReader(csvFile);
			csvReader = new CSVReader(fileReader);
			csvReader.readNext();// reading col names --- Row 1 skip the col names

			userlist = new ArrayList<User>();

			while ((line = csvReader.readNext()) != null) {
				userData = new User(line[0], line[1]);
				userlist.add(userData);

			}

		} catch (CsvValidationException | IOException e) {
			e.printStackTrace();
		}
		return userlist.iterator();
	}

}
