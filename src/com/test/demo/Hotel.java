package com.test.demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Hotel {
	public static void main(String[] args) {
		System.setProperty("WebDriver.chrome.driver", "C:/Users/AJOHNMAR/Downloads/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://hoteling.capgemini.com/reservationContent/newReservation");
		WebElement wb=driver.findElement(By.xpath("//span[@class='mat-button-wrapper' and text()='No']"));
		wb.click();
		//driver.switchTo().alert().dismiss();
		WebElement wbd=driver.findElement(By.xpath("//div[@class='closeBtnWrapper']"));
		wbd.click();
		WebElement ws=driver.findElement(By.xpath("//button[@class='btn btn-default balloonButton']"));
		ws.click();
		Select cls=new Select(driver.findElement(By.xpath("//select[@name='country']")));
		cls.selectByValue("IN");
		Select cls1=new Select(driver.findElement(By.xpath("//select[@name='city']")));
		cls1.selectByValue("46699");
		Select cls2=new Select(driver.findElement(By.xpath("//select[@name='building']")));
		cls2.selectByVisibleText("PCT");
		Select cls3=new Select(driver.findElement(By.xpath("//select[@name='floor']")));
		cls3.selectByValue("38");
		WebElement ws1=driver.findElement(By.xpath("//td[@class='day disabled']//following::td[@class='day new']"));
		ws1.click();
		
	}

}
