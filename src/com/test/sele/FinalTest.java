package com.test.sele;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FinalTest {
	public static void main(String[] args) {
		System.setProperty("WebDriver.chrome.driver", "C:/Users/AJOHNMAR/Downloads/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get("https://ultimateqa.com/dummy-automation-websites/#SauceDemo_E-Commerce");
		driver.manage().window().maximize();
		String Parent=driver.getWindowHandle();
		System.out.println(Parent);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//WebElement search=driver.findElement(By.linkText("https://forms.clickup.com/2314027/f/26ktb-6387/56LKNUZ9BDYXSC73SY"));
		//search.click();
		WebElement seh=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("https://forms.clickup.com/2314027/f/26ktb-6387/56LKNUZ9BDYXSC73SY")));
		seh.click();
	}

}
