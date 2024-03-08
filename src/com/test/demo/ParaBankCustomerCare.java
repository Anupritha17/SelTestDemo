package com.test.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.test.utils.DriverUtils;
//using a Map to store the Excel values, 
//key is the element name and the value is the corresponding value from the Excel file.
public class ParaBankCustomerCare {
    static WebDriver driver;
    static DriverUtils util;
    static Map<String, String > excelValues = new HashMap<>();
    @Test
    public static void demo() throws IOException {
//   public static void main(String[] args) throws IOException {
        try {
        	readExcelValues();
            OpenApp();
            accessCustomerCare();
            validateNoFillsErrorMsg();
            validateCustomerDetailsErrorMsg();
        } catch (AssertionError e) {
            handleAssertionFailure(e);
        } finally {
            endSelenium();
        }
    }

    private static void readExcelValues() throws IOException {
        FileInputStream fs = new FileInputStream("C:/Users/AJOHNMAR/Downloads/Work.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            String element = row.getCell(0).getStringCellValue();
            Cell valueCell = row.getCell(1);

            excelValues.put(element, getStringCellValue(valueCell));
        }
        workbook.close();
    }

    private static String getStringCellValue(Cell cell) {
        if (cell == null) {
            return null;
        } else if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            // here converting numeric value to string
            return String.valueOf(cell.getNumericCellValue());
        } else {
            return null;
        }
    }

    private static void OpenApp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/AJOHNMAR/Downloads/chromedriver.exe");
        driver = new ChromeDriver();
        util = new DriverUtils(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/");
    }

    private static void accessCustomerCare() {
        util.Click(excelValues.get("customerCareBtn"));
        util.Click(excelValues.get("submitBtn"));
        util.Click(excelValues.get("errorMsg"));
    }

    private static void validateNoFillsErrorMsg() {
        System.out.println(util.GetText(excelValues.get("errorMsg")));
        Assert.assertEquals(excelValues.get("errorMsgVal"), util.GetText(excelValues.get("errorMsg")));
    }

    private static void validateCustomerDetailsErrorMsg() {
        util.Sendkeys(excelValues.get("nameTextBox"), excelValues.get("nameValue"));
        util.Sendkeys(excelValues.get("emailTextBox"), excelValues.get("emailVaule"));
        util.Sendkeys(excelValues.get("phoneTexBox"), excelValues.get("phoneNumber"));
        util.Sendkeys(excelValues.get("messageTexBox"), excelValues.get("message"));
        util.Click(excelValues.get("submitBtnwithValues"));
        System.out.println(util.GetText(excelValues.get("afterSubmitMessageVal")));
        Assert.assertEquals(excelValues.get("afterSubmitConformationMessage"), util.GetText(excelValues.get("afterSubmitMessageVal")));
    }

    private static void handleAssertionFailure(AssertionError e) {
        System.out.println("Assertion failed: " + e.getMessage());
    }
    @AfterClass
    private static void endSelenium() {
        driver.quit();
    }
}
