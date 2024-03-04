package com.test.demo;

import java.time.Duration;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.test.utils.DriverUtils;


public class Hotel {

	static WebDriver driver;
	static DriverUtils util;
	static String noBtn = "//span[@class='mat-button-wrapper' and text()='No']";
	static String closeBtn = "//div[@class='closeBtnWrapper']";
	static String ballonBtn = "//button[@class='btn btn-default balloonButton']";

	static String countryDropDown = "//select[@name='country']";
	static String india = "IN";
	static String cityDropDown = "//select[@name='city']";
	static String chennai = "46699";
	static String buildingDropDown = "//select[@name='building']";
	static String buildingName = "IN036OF01";
	static String floorDropDown = "//select[@name='floor']";
	static String floorNumber = "38";

	static String findBuilding = "//label[@class='link serachOfficeBtn']";
	static String enterName = "//input[@class='form-control ng-pristine ng-valid ng-touched']";
	static String inputVal = "PCT";
	static String closeBtn2 = "//button[@class='btn btn-secondary']";
	static String dataSelectionBtn = "//td[@data-day='03/01/2024']";
	static String bookBtn = "//button[@type='button' and text()='Book']";
	static String getTextmsg = "//p[@class='m-0 ng-star-inserted']";
	static String getErrorMsg=" fulfil The system cannot";

	public static void main(String[] args) {
		OpenApplication();
		CloseInitialPrompts();
		SelectSeatBookingOptions();
		//FindBuildingName();
		GetText();
		driver.quit();
	}

	private static WebDriver OpenApplication() {
		System.setProperty("WebDriver.chrome.driver", "C:/Users/AJOHNMAR/Downloads/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://hoteling.capgemini.com/reservationContent/newReservation");
		util = new DriverUtils(driver);
		return driver;
	}

	private static void CloseInitialPrompts() {
		util.Click(noBtn);
		util.Click(closeBtn);
		util.Click(ballonBtn);

	}

//	private static void FindBuildingName() {
//		util.Click(findBuilding);
//		util.Sendkeys(enterName, inputVal);
//		util.Click(closeBtn2);
//
//	}

	private static void SelectSeatBookingOptions() {
		util.Select(countryDropDown, india);
		util.Select(cityDropDown, chennai);
		util.Select(buildingDropDown, buildingName);
		util.Select(floorDropDown, floorNumber);
		util.Click(dataSelectionBtn);
		util.Click(bookBtn);
	}
	
	private static void GetText() {
		System.out.println(util.GetText(getTextmsg));
		//assert getErrorMsg.equals(util.GetText(getTextmsg));
		//Assert.assertEquals(util.GetText(getTextmsg),"Please enter your Email ID");
		Assert.assertEquals(getErrorMsg,util.GetText(getTextmsg));
		

	}

}
