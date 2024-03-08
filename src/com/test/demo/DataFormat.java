package com.test.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.test.utils.DriverUtils;

public class DataFormat {
    static WebDriver driver;
    static DriverUtils util;
    
    // Declare variables to hold Excel values
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
    
    public static void main(String[] args) throws IOException {
        readExcelValues();
        try {
            OpenApp();
            accessCustomerCare();
            validateNoFillsErrorMsg();
            validateCustomerDetailsErrorMsg();
        }catch (AssertionError e) {
            handleAssertionFailure(e);
        }finally {
            endSelenium();
        }
    }

    private static void readExcelValues() throws IOException {
        FileInputStream fs = new FileInputStream("C:/Users/AJOHNMAR/Downloads/Work.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheetAt(0);
        DataFormatter formatter = new DataFormatter();

        for (Row row : sheet) {
            String element = formatter.formatCellValue(row.getCell(0));
            String value = formatter.formatCellValue(row.getCell(1));
            
            switch (element) {
                case "afterSubmitConformationMessage":
                    afterSubmitConformationMessage = value;
                    break;
                case "afterSubmitMessageVal":
                    afterSubmitMessageVal = value;
                    break;
                case "customerCareBtn":
                    customerCareBtn = value;
                    break;
                case "errorMsg":
                    errorMsg = value;
                    break;
                case "errorMsgVal":
                    errorMsgVal = value;
                    break;
                case "emailTextBox":
                    emailTextBox = value;
                    break;
                case "emailVaule":
                    emailVaule = value;
                    break;
                case "messageTexBox":
                    messageTexBox = value;
                    break;
                case "message":
                    message = value;
                    break;
                case "nameTextBox":
                    nameTextBox = value;
                    break;
                case "nameValue":
                    nameValue = value;
                    break;
                case "phoneTexBox":
                    phoneTexBox = value;
                    break;
                case "phoneNumber":
                    phoneNumber = value;
                    break;
                case "submitBtn":
                    submitBtn = value;
                    break;
                case "submitBtnwithValues":
                    submitBtnwithValues = value;
                    break;
                default:
                    break;
            }
        }
        workbook.close();
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

