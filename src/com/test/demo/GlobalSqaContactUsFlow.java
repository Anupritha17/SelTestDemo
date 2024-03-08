package com.test.demo;

import java.time.Duration;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.utils.DriverUtils;




public class GlobalSqaContactUsFlow {

	static WebDriver driver;
	static DriverUtils util;
	static WebDriverWait wait;
	static String countryDropDown = "//option[@value='IND']";
	static String contactUs = "//a[@href='https://www.globalsqa.com/contact-us/']";
	// static String alert="//span[@class='ns-zzbua-e-21']";
	static String name = "//input[@name='comment_name']";
	static String value = "Sneha";
	static String email = "//input[@name='email']";
	static String emailValue = " Sneha12@gmail.com";
	static String subject = "//input[@name='subject']";
	static String subjectValueBox = "Enter the subject line";
	// static String captcha="//span[@id='recaptcha-anchor']";
	static String submitBtn = "//input[@name='submit']";
	static String textError = "//div[@class='warning_msg closable']";
	static String text = "//p[contains (text(), 'We are')]";
	static String ms = "//a[@href='https://www.globalsqa.com/testers-hub/']";
	static String sampleTestPage = "//a[@href='https://www.globalsqa.com/samplepagetest/']";
	static String errorMsg="Wrong msg";

	public static void main(String[] args) {
		OpenApp();
		SelectCountry();
		FillContactUsDetails();
		ValidateErrorMsg();
	}

	private static WebDriver OpenApp() {
		System.setProperty("WebDriver.chrome.driver", "C:/Users/AJOHNMAR/Downloads/chromedriver.exe");
		driver = new ChromeDriver();
		util = new DriverUtils(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		return driver;
	}

	private static void SelectCountry() {
		util.Click(countryDropDown);
		util.Click(contactUs);
	}

	private static void FillContactUsDetails() {
		util.Sendkeys(name, value);
		util.Sendkeys(email, emailValue);
		util.Sendkeys(subject, subjectValueBox);
		// util.Click(captcha);
		util.Click(submitBtn);
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(name))).sendKeys(value);
		// driver.findElement(name)

	}

	private static void ValidateErrorMsg() {
		System.out.println(util.GetText(textError));
		//assert errorMsg.equals(util.GetText(textError));
		Assert.assertEquals(util.GetText(textError),errorMsg);
		//Assert.assertEquals(errorMsg, util.GetText(textError));
		//System.out.println(“IRCTC text is a expected – Assert passed”);
		//System.out.println(util.GetText(text));
	}

}
