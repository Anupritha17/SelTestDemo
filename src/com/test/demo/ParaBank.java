package com.test.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.utils.DriverUtils;

public class ParaBank {
    static WebDriver driver;
    static DriverUtils util;
    
    // Just Declaring variables to hold Excel values
    static String afterSubmitConformationMessage;
    static String afterSubmitMessageVal;
    static String customerCareBtn;
    static String errorMsg;
    static String errorMsgVal;
    static String emailTextBox;
    static String emailVaule;
    static String messageTexBox;
    static String message;
    static String nameTextBox;
    static String nameValue;
    static String phoneTexBox;
    static String phoneNumber;
    static String submitBtn;
    static String submitBtnwithValues;
    
    @Test
    public static void Demo() throws IOException{
        
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
//excel,json
            switch (element) {
                case "afterSubmitConformationMessage":
                    afterSubmitConformationMessage = getStringCellValue(valueCell);
                    break;
                case "afterSubmitMessageVal":
                    afterSubmitMessageVal = getStringCellValue(valueCell);
                    break;
                case "customerCareBtn":
                    customerCareBtn = getStringCellValue(valueCell);
                    break;
                case "errorMsg":
                    errorMsg = getStringCellValue(valueCell);
                    break;
                case "errorMsgVal":
                    errorMsgVal = getStringCellValue(valueCell);
                    break;
                case "emailTextBox":
                    emailTextBox = getStringCellValue(valueCell);
                    break;
                case "emailVaule":
                    emailVaule = getStringCellValue(valueCell);
                    break;
                case "messageTexBox":
                    messageTexBox = getStringCellValue(valueCell);
                    break;
                case "message":
                    message = getStringCellValue(valueCell);
                    break;
                case "nameTextBox":
                    nameTextBox = getStringCellValue(valueCell);
                    break;
                case "nameValue":
                    nameValue = getStringCellValue(valueCell);
                    break;
                case "phoneTexBox":
                    phoneTexBox = getStringCellValue(valueCell);
                    break;
                case "phoneNumber":
                    phoneNumber = getStringCellValue(valueCell);
                    break;
                case "submitBtn":
                    submitBtn = getStringCellValue(valueCell);
                    break;
                case "submitBtnwithValues":
                    submitBtnwithValues = getStringCellValue(valueCell);
                    break;
                default:
                    break;
            }
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
        util.Click(customerCareBtn);
        util.Click(submitBtn);
        util.Click(errorMsg);
    }

    private static void validateNoFillsErrorMsg() {
        System.out.println(util.GetText(errorMsg));
        Assert.assertEquals(errorMsgVal, util.GetText(errorMsg));
    }

    private static void validateCustomerDetailsErrorMsg() {
        util.Sendkeys(nameTextBox, nameValue);
        util.Sendkeys(emailTextBox, emailVaule);
        util.Sendkeys(phoneTexBox, phoneNumber);
        util.Sendkeys(messageTexBox, message);
        util.Click(submitBtnwithValues);
        System.out.println(util.GetText(afterSubmitMessageVal));
        Assert.assertEquals(afterSubmitConformationMessage, util.GetText(afterSubmitMessageVal));
    }

    private static void handleAssertionFailure(AssertionError e) {
        System.out.println("Assertion failed: " + e.getMessage());
    }

    private static void endSelenium() {
        driver.quit();
    }
}
