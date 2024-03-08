package com.test.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.test.utils.DriverUtils;

public class Geeks {
	static WebDriver driver;
    static DriverUtils util;
	private static String customerCareBtn;
    
public static void main(String[] args) throws IOException {
            OpenApp();
            accessCustomerCare();
    }

	@Test
	public void geekforgeeks() throws IOException {

		FileInputStream file = new FileInputStream("C:/Users/AJOHNMAR/Downloads/Work.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sh = wb.getSheetAt(0);

		HashMap<String, String> map = new HashMap<String, String>();

		for (int r = 0; r <= sh.getLastRowNum(); r++) {
			String key = sh.getRow(r).getCell(0).getStringCellValue();
			String value = sh.getRow(r).getCell(1).getStringCellValue();
			map.put(key, value);
		}

		// Displaying HashMap
		Iterator<Entry<String, String>> new_Iterator = map.entrySet().iterator();

		while (new_Iterator.hasNext()) {
			Map.Entry<String, String> new_Map = (Map.Entry<String, String>) new_Iterator.next();
		}
		
		wb.close();
		file.close();
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
    }
}
