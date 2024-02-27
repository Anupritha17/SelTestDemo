package com.test.sele;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestDemo {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/AJOHNMAR/Downloads/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://talent.capgemini.com/in");
		//driver.findElement()
		driver.manage().window().maximize();
		driver.findElement(By.id("cookie_info")).click();
		WebElement searchbox = driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));
		searchbox.sendKeys("mobile5g");
		searchbox.sendKeys(Keys.ENTER);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement search=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//fghjs[@lskl='ajfoi']")));
	}

}
