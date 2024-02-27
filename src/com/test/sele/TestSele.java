package com.test.sele;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSele {
	public static void main(String[] args) {
		// Invoking the browser, selenium runs on different browser
		// firefox-firefoxDriver----All the methods are same in all the browser
		// (close,get)
		// Chrome-ChromeDriver-->class able access all the methods

		// WEBDRIVER for all these there is an interface which directs what to do and
		// WITH EMPTY BODIES AND WHICH ALSO CLASS IMPLEMENTS AND WRITE THE BODY AND WORK
		// ChromeDriver driver=new ChromeDriver();

		// Step to ivoke chrome driver
		// Selenium manager
		System.setProperty("webdriver.chrome.driver", "C:/Users/AJOHNMAR/Downloads/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:/Users/AJOHNMAR/Downloads/geckodriver.exe");
		//System.setProperty("webdriver.edge.driver", "C:/Users/AJOHNMAR/Downloads/msedgedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		//WebDriver driver = new FirefoxDriver();
		driver.close();
		driver = new EdgeDriver();
		//driver2.get("https://www.w3schools.com/java/java_arrays.asp");
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		//driver2.quit();//all associated window will close
		

	}

}
