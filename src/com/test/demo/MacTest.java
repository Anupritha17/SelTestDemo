package com.test.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MacTest {
public static void main(String[] args) {
	
	System.setProperty("WebDriver.chrome.driver", "C:/Users/AJOHNMAR/Downloads/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	JavascriptExecutor js=(JavascriptExecutor)driver;
	driver.get("https://www.apple.com/in/mac/");
	driver.manage().window().maximize();
	Actions action=new Actions(driver);
	WebElement ms=driver.findElement(By.xpath("//span[@class='globalnav-link-text' and text()='Accessories']"));
	action.moveToElement(ms).perform();
	js.executeScript("window.scrollBy(0,1500)");
	
}
}
