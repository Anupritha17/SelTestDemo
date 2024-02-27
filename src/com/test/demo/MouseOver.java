package com.test.demo;


import java.io.IOException;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class MouseOver {
	public void mousetest() {
	System.setProperty("WebDriver.chrome.driver", "C:/Users/AJOHNMAR/Downloads/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	Actions actions=new Actions(driver);
	driver.get("https://demo.guru99.com/test/newtours");
	driver.manage().window().maximize();
	WebElement ms=driver.findElement(By.xpath("//a[@href='support.php']"));
	actions.moveToElement(ms).perform();
	WebElement validation=driver.findElement(By.xpath("//a[text()='Hotels']"));
	boolean isvalidate=validation.isDisplayed();
	if(isvalidate) {
		System.out.println("Validation done");
	}else {
		System.out.println("Validation is not done");
	}
	driver.close();
}
}
