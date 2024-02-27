package com.test.sele;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GWeb {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/AJOHNMAR/Downloads/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/test/selenium-xpath.html");
		driver.findElement(By.name("uid")).sendKeys("ANUPRITHA");
		System.out.println(driver.findElement(By.xpath("//label[@id='message23']")).getText());
		driver.findElement(By.name("password")).sendKeys("Annu@123");
		System.out.println(driver.findElement(By.xpath("//label[@id='message18']")).getText());
		driver.findElement(By.cssSelector("input[type='submit']")).click();
	    //Multiple attribute
		driver.findElement(By.xpath("//a[@target='_top' and @title='Software Testing']")).click();
		//Using AND OR NOT
		driver.findElement(By.xpath("//input[@type='submit' or @value='RESET']")).click();
		driver.findElement(By.xpath("//a[not(contains[@target='_top'])and @title='Software Testing']")).click();
		//Starts with
		driver.findElement(By.xpath("//h1[starts-with(@class,'thick')]")).click();
		
		


	}

}
