package com.test.sele;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flip {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/AJOHNMAR/Downloads/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.flipkart.com");
		// --Using single slash
		// river.findElement(By.xpath("/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[1]/div[2]/form/div/div/input")).sendKeys("5GMobile");
		// --Double slash
		WebElement searchbox = driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));
		searchbox.sendKeys("mobile5g");
		searchbox.sendKeys(Keys.ENTER);
		// --Starts with
		 System.out.println(driver.findElement(By.xpath("//img[starts-with(@loading,'eager')]")).getText());
		// --Contains
		// driver.findElement(By.xpath("//img[contains(@loading,'eager')]"));
		// ---AND OR NOT
		// driver.findElement(By.xpath("//input[not(@xmlns)and(contains(@class='_3704LK')or(contains(@title='Search
		// for products, brands and more')))]"));
		//System.out.println(driver.findElement(By.xpath("//a[@class='_2whKao'])")).getText());
		// ---Find using Index
		// driver.findElement(By.xpath("//img[@loading='eager'][1]")).click();
		// ---Find using last
		//driver.findElement(By.xpath("//img[@loading='eager'][last()]")).click();
		// ---Find using position
		//driver.findElement(By.xpath(("(//label)[position()=2]"))).click();
		
		// tagname[@Attribute='value']//preceding::tagname//Select all the node that appears before the context
		//driver.findElement(By.xpath("//meta[@property='fb:admins']//preceding-sibling::link")).click();
		
		// tagname[@Attribute='value']//following::tagname//select all the nodes that appear after the current node
		
		//driver.findElement(By.xpath(("//input[@type='hidden']//following::input[@type='hidden']"))).click();
        //tagname[@Attribute='value']//following-sibling::tagname//select all the nodes that has same parent and appear after the current node

	}

}
