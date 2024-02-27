package com.test.demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelSTest {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://englishonline.britishcouncil.org/");
		WebElement L1=driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
		L1.click();
		WebElement L2=driver.findElement(By.xpath("//span[@class='button__text' and text()='Login'] [position()=1]"));
		L2.click();
		driver.findElement(By.xpath("//input[@class='form__field__input']")).sendKeys("annujohn17@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Annu@123");
		driver.findElement(By.xpath("//span[@class='form__field--choice__text']")).click();
		WebElement L3=driver.findElement(By.xpath("//button[@id='checkemail']"));
		L3.click();
	    //System.out.println(driver.findElement(By.xpath("//div[@class='form__message--error']")).getText());;
		System.out.println(driver.getCurrentUrl());
		List <WebElement> hyperlk=driver.findElements(By.tagName("a"));
		for(WebElement link: hyperlk) {
			System.out.println("Print all the hyperlink in webpage"+link.getAttribute("href"));
		}
		
	}
	

}
