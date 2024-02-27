package com.test.sele;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Locators
//ID,XPATH,CSS SELECTOR,NAME,CLASS NAME,TAG NAME,LINK TEXT, PARTIAL LINK TEXT
//<input autocomplete="off" type="text" class="_2IX_2- VJZDxU" value="">
public class Locat {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/AJOHNMAR/Downloads/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://profile.w3schools.com/");
		driver.findElement(By.name("email")).sendKeys("annujohn17@gmail.com");
		driver.findElement(By.id("current-password")).sendKeys("Annu@123");
		driver.findElement(By.className("Button_button__URNp+")).click();
		//construct form the given html code and css if not there we can created with whatever available
		
		//Css Selector
		//class name--->tagname.classname
		//ID--_>tagname#id
		//tagname[attribute='value']
		System.out.println(driver.findElement(By.cssSelector("div.Alert_iwrp__5q1xH")).getText());
		//driver.findElement(By.linkText("https://profile.w3schools.com/reset")).click();
		//driver.findElement(By.cssSelector("a[href='Forgot password?']")).click();
		//driver.findElement(By.className("ButtonV2_text__hrU4c")).click();
		//XPATH--->//TagName[@attribute='value']
		//driver.findElement(By.xpath("//a[@href='https://profile.w3schools.com/reset']")).click();
		//driver.findElement(By.xpath("//a[@class='ButtonV2_button_wrapper__Tb921']")).click();
		//parent/child--xpath
		//parent child---css
		//driver.findElement(By.xpath("//div/a")).click();
		//driver.findElement(By.cssSelector(".LoginModal_forgot_pwd_wrapper__qttSX")).click();
	//By.xpath("//input[@title='Search for Products, Brands and More']").
	}

}
