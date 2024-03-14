package com.test.assessment;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ChromeCpuComparison {
	static WebDriver driver;
	static DriverUtilsTest util;
	static Map<String, String> value = new HashMap<>();

	@Test
	public static void test() throws IOException {
		openApplication();
		readExcelValues();
		getXpathValuesFromExcel();
		compareBothValues();
		closeApplication();
	}

	public static void openApplication() {
		util = new DriverUtilsTest(driver);
		util.OpenApplication("https://practice.expandtesting.com/dynamic-table");
	}

	public static void readExcelValues() throws IOException {
		FileInputStream fs = new FileInputStream("C:/Users/AJOHNMAR/Downloads/AddValues.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sheet = wb.getSheetAt(0);

		for (Row row : sheet) {
			String elements = row.getCell(0).getStringCellValue();
			String xpathValues = row.getCell(1).getStringCellValue();
			value.put(elements, xpathValues);
		}

		wb.close();
	}

	public static void getXpathValuesFromExcel() {
		System.out.println(util.GetText(value.get("tableCell")));
		System.out.println(util.GetText(value.get("highlightedCell")).replace("Chrome CPU: ", "").trim());
	}

	public static void compareBothValues() {
		String tableCellValue = util.GetText(value.get("tableCell"));
		String highlightedCellValue = util.GetText(value.get("highlightedCell")).replace("Chrome CPU:", "").trim();
		Assert.assertEquals(tableCellValue, highlightedCellValue, "The CPU Load values are different");
	}

	@AfterMethod
	public static void closeApplication() {
		util.closeWindow();
	}

}
