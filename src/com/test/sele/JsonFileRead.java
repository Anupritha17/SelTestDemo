package com.test.sele;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.test.utils.DriverUtils;

public class JsonFileRead {
	static WebDriver driver;
	static DriverUtils util;
	
	public static void OpenApp() {
		driver=new ChromeDriver();
		util=new DriverUtils(driver);
		System.setProperty("WebDriver.chrome.driver", "C:/Users/AJOHNMAR/Downloads/chromedriver.exe");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://profile.w3schools.com/");
	}
	
	public static void main(String args[]) throws FileNotFoundException, IOException, ParseException {
		OpenApp();
		nextMethod();
//		JSONParser jsonparser=new JSONParser();
//		JSONObject jsonObject=(JSONObject)jsonparser.parse(new FileReader("C:/Users/AJOHNMAR/NewNTest/Seleproject/json/read.json"));
//		String id=(String) jsonObject.get("EmployeeID");
//		String firstName=(String) jsonObject.get("FirstName");
//		String lastname=(String) jsonObject.get("LastName");
//		String country=(String)jsonObject.get("Country");
//		System.out.println(id);
//		System.out.println(firstName);
//		System.out.println(lastname);
//		System.out.println(country);
		
		
	}
public static void nextMethod() throws FileNotFoundException, IOException, ParseException {
	JSONParser jsonparser=new JSONParser();
	JSONObject jsonObject=(JSONObject)jsonparser.parse(new FileReader("C:/Users/AJOHNMAR/NewNTest/Seleproject/json/UseNam.json"));
	String email=(String) jsonObject.get("Email");
	String passowrd=(String) jsonObject.get("Password");
	String Xpath=(String)jsonObject.get("Xpath");
	//util.Sendkeys(Xpath, Xpath);)
	driver.findElement(By.xpath("//input[@class='EmailInput_input_field__6t4Ux undefined']")).sendKeys(email);
	driver.findElement(By.xpath("//input[@class='PasswordInput_input_field__EWMIU undefined']")).sendKeys(passowrd);
	test(Xpath);
}
public static void test(String xpath) {
	util.Click(xpath);
}
}
