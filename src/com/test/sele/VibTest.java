package com.test.sele;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VibTest {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "C:/Users/AJOHNMAR/Downloads/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
	driver.get("https://profile.w3schools.com/");
	String parent=driver.getWindowHandle();
	System.out.println(parent);
	System.out.println(driver.getTitle());
	System.out.println(driver.getCurrentUrl());
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.findElement(By.className("EmailInput_input_field__6t4Ux")).sendKeys("annujohn17@gmail.com");
	driver.findElement(By.id("current-password")).sendKeys("Annu@123");
	driver.findElement(By.className("Button_button__URNp+")).click();
	WebElement searc=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@target='blank']")));
	searc.click();
//	Set <String> chHandel=driver.getWindowHandles();
//	for(String Handel:chHandel) {
//		System.out.println(Handel);
//		if(!Handel.equals(parent)) {
//			driver.switchTo().window(Handel);
	
			//WebElement search=driver.findElement(By.xpath("//input[@aria-label='Search field']"));
	
//	searc.sendKeys("JAVA");
//	
//	searc.sendKeys(Keys.ENTER);
			System.out.println(driver.getCurrentUrl());
//		}
//	}
			
			Set<String> childHandel=driver.getWindowHandles();
			for(String chhandel:childHandel) {
				System.out.println(chhandel);
				if(!chhandel.equals(parent)) {
					driver.switchTo().window(parent);
				}
				}
	
	//search.sendKeys("JAVA");
	//search.sendKeys(Keys.ENTER);
//	WebElement search=driver.findElement(By.xpath("//tagename[@attribute='value']"));
//	search.sendKeys("Anuuu");
//	search.sendKeys("Keys.ENTER");
//	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
//	WebElement sys=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));
//			sys.click();
//			String parenthandel=driver.getWindowHandle();
//			System.out.println(parenthandel);
//			Set<String> childHandel=driver.getWindowHandles();
//			for(String chhandel:childHandel) {
//				System.out.println(chhandel);
//				if(!chhandel.equals(parenthandel)) {
//					driver.switchTo().window(parenthandel);
//				}
//				driver.switchTo().window(chhandel);
//			}
//			
			
}
}
