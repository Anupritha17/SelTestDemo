package com.test.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
//import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.test.utils.DriverUtils;

public class ParabankFlow {
	static WebDriver driver;
	static DriverUtils util;
	
	static String afterSubmitConformationMessage = "A Customer Care Representative will be contacting you.";
	static String afterSubmitMessageVal = "//p[contains(text(), 'A Customer Care Representative')]";
	static String customerCareBtn = "//a[text()='contact']";
	static String errorMsg = "//span[@id='name.errors']";
	static String errorMsgVal = "ame is required.";
	static String emailTextBox = "//input[@name='email']";
	static String emailVaule = "annujohn172@gmail.com";
	static String messageTexBox = "//textarea[@name='message']";
	static String message = "Message to be passed inside the TextBox";
	static String nameTextBox = "//input[@name='name']";
	static String nameValue = "AnuPritha";
	static String phoneTexBox = "//input[@name='phone']";
	static String phoneNumber = "9876543210";
	static String submitBtn = "//input[@type='submit' and @value='Send to Customer Care']";
	static String submitBtnwithValues = "//input[@type='submit' and @value='Send to Customer Care']";
	
	
	public static void main(String[] args) throws IOException {
		 try {
	            OpenApp();
	            accessCustomerCare();
	            validateNoFillsErrorMsg();
	            validateCustomerDetailsErrorMsg();
	            closeWindow();
	        } catch (AssertionError e) {
	            handleAssertionFailure(e);
	        } 
	        finally {
	            endSelenium();
	        }
//	            try {
//	                // Your test actions and assertions here
//	                Assert.assertEquals(driver.getTitle(), "Expected Title");
//	            } catch (AssertionError e) {
//	                // Assertion failed, perform cleanup (close browser)
//	                driver.quit();
//	                throw e; // Re-throw the assertion error to mark the test as failed
//	            }
	}
	
	private static WebDriver OpenApp() {
		System.setProperty("WebDriver.chrome.driver", "C:/Users/AJOHNMAR/Downloads/chromedriver.exe");
		driver = new ChromeDriver();
		util = new DriverUtils(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://parabank.parasoft.com/");
		return driver;
	}
	
	private static void accessCustomerCare() throws IOException {
//		FileInputStream fs = new FileInputStream("C:/Users/AJOHNMAR/Downloads/Work.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fs);
//		XSSFSheet sheet1 = workbook.getSheetAt(0);
//		String ss;
//		for (Row row : sheet1) {
//			if (row.getCell(0).toString().equals("customerCareBtn")) {
//				ss = row.getCell(1).toString();
//				util.Click(ss);
//			}
//		}
		
//		for (Row row : sheet1) {
//            // Check if the first cell of the row contains the target value
//            if (row.getCell(0) != null && row.getCell(0).toString().equals("customerCareBtn")) {
//                // Get the value from the second cell of the row
//                Cell cell = row.getCell(1);
//                if (cell != null) {
//                    String value = cell.getStringCellValue();
//                    String submitBtn = cell.getStringCellValue();
//                    String errorMsg = cell.getStringCellValue();

                    // Perform your actions using the value (e.g., clicking)
                    util.Click(customerCareBtn);
                    util.Click(submitBtn);
            		util.Click(errorMsg);
                }
//            		}
//            	}
//	}
		
	
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
    
	@AfterMethod
    public static void closeWindow() {
        // browser is closed after each test method execution
            driver.quit();
    }

}
