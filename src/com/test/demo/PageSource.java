package com.test.demo;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageSource {
	

	public void test() {
		System.setProperty("WebDriver.chrome.driver", "C:/Users/AJOHNMAR/Downloads/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours");
		List<WebElement> price = driver.findElements(By.xpath("//b[contains(text(), '$')]"));
		int maxprice = 0;
		for (WebElement priceEm : price) {
			String convStr = priceEm.getText().replaceAll("[^0-9]", "");
			int priceEv = Integer.parseInt(convStr);
			maxprice = Math.max(maxprice, priceEv);
		}
		System.out.println(maxprice);
//	String date="Jul 6, 2017";
//	if(driver.getPageSource().contains(date)) {
//		System.out.println(date+" Date is present in the website");
//	}else {
//		System.out.println("Date is not present");
//	}
		WebElement d1 = driver.findElement(By.xpath("//b[contains(text(),'Jul 6, 2017')]"));
		String Text = d1.getText();
		System.out.println(Text);
		String Wordtocheck = "Jul 6, 2017";
		boolean persent = Text.contains(Wordtocheck);
		if (persent) {
			System.out.println("present" + Text);

		} else {
			System.out.println("Not present" + Text);
		}

	}

public static void main(String[] args) {
	MouseOver tet=new MouseOver();
	PageSource obj=new PageSource();
	obj.test();
	tet.mousetest();
    DemoSel.ter();
	
	
}
}