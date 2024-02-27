package com.test.demo;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class StcJs {
	public static void main(String[] args) {
	System.setProperty("Webdriver.chrome.driver", "C:/Users/AJOHNMAR/Downloads/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	JavascriptExecutor js=(JavascriptExecutor)driver;
	 driver.get("https://www.browserstack.com/users/sign_in");
	 js.executeScript("document.getElementById('user_email_login').value='rbc@xyz.com';");
		
	}

}
