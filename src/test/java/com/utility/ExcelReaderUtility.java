package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {

	public static Iterator<User> readExcelFile(String fileName) {

		File xlsxfilee = new File(System.getProperty("user.dir") + File.separator + "testData" + File.separator + fileName);// loginData.xlsx

		XSSFWorkbook xssfWorkbook = null;
		XSSFSheet xssfSheet;
		List<User> userList = null;
		Iterator<Row> rowIterator;

		try {
			xssfWorkbook = new XSSFWorkbook(xlsxfilee);

			xssfSheet = xssfWorkbook.getSheet("LoginTestData");
			rowIterator = xssfSheet.iterator();
			rowIterator.next();
			userList = new ArrayList<User>();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Cell emailAddressCell = row.getCell(0);
				Cell passwordCell = row.getCell(1);
				User user = new User(emailAddressCell.toString(), passwordCell.toString());
				userList.add(user);

			}
			System.out.println(userList);

		} catch (InvalidFormatException | IOException e) {

			e.printStackTrace();
		}

		return userList.iterator();
	}

}
