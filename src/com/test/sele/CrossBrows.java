package com.test.sele;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrossBrows{
	static WebDriver driver;
	public void setup(String browser) throws Exception{
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/Users/AJOHNMAR/Downloads/chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("Firefox")) {
			driver=new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("Edge")) {
			driver=new EdgeDriver();
		}else {
			throw new Exception("Incorrect browser");
		}
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public static void main(String[] args) {
		driver.get("https://www.w3schools.com/java/java_arrays.asp");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	}
}

