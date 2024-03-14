package com.test.assessment;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RegisterUserFlow {
	private static WebDriver driver;
	private static DriverUtilsTest util;

	public static void openApplication() {
		util = new DriverUtilsTest(driver);
		util.OpenApplication("https://demo.automationtesting.in/Index.html");
	}

	@Test
	public static void test() throws FileNotFoundException, IOException, ParseException {
		openApplication();
		accessJson();
		closeApplication();
	}

	public static void accessJson() throws FileNotFoundException, IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObj = (JSONObject) jsonParser
				.parse(new FileReader("C:/Users/AJOHNMAR/NewNTest/Seleproject/json/assessment.json"));

		String clickBtn = (String) jsonObj.get("skipsigninButton");
		String dayXpath = (String) jsonObj.get("dayxpath");
		String dayValue = (String) jsonObj.get("dayvalue");
		String firstName = (String) jsonObj.get("firstnamexpath");
		String firstNameValue = (String) jsonObj.get("firstname");
		String genderBtn = (String) jsonObj.get("genderxpath");
		String hobbyBtn = (String) jsonObj.get("hobby1");
		String hobbiesBtn = (String) jsonObj.get("hobby2");
		String lastName = (String) jsonObj.get("lastnamexpath");
		String lastNameValue = (String) jsonObj.get("lastname");
		String monthXpath = (String) jsonObj.get("monthxpath");
		String monthValue = (String) jsonObj.get("monthvalue");
		String userSubmitBtn = (String) jsonObj.get("usersubmit");
		String yearValue = (String) jsonObj.get("yearxpath");
		String yearDropDown = (String) jsonObj.get("yearSelect");

		if (clickBtn != null && genderBtn != null && hobbyBtn != null && hobbiesBtn != null && userSubmitBtn != null
				&& yearValue != null && yearDropDown != null && monthXpath != null && monthValue != null
				&& dayXpath != null && dayValue != null && firstName != null && firstNameValue != null
				&& lastName != null && lastNameValue != null) {
			performClickOperations(clickBtn, genderBtn, hobbyBtn, hobbiesBtn, userSubmitBtn, yearValue, yearDropDown,
					monthXpath, monthValue, dayXpath, dayValue);
			performSendKeysOperations(firstName, firstNameValue, lastName, lastNameValue, userSubmitBtn);
		} else {
			System.out.println("Some required fields are missing.");
		}

	}

	public static void performClickOperations(String clickBtn, String genderBtn, String hobbyBtn, String hobbiesBtn,
			String userSubmitBtn, String yearValue, String yearDropDown, String monthXpath, String monthValue,
			String dayXpath, String dayValue) {
		util.Click(clickBtn);
		util.Click(genderBtn);
		util.Click(hobbyBtn);
		util.Click(hobbiesBtn);
		util.Click(userSubmitBtn);
		util.Click(yearValue);
		util.Click(yearDropDown);
		util.Click(monthXpath);
		util.Click(monthValue);
		util.Click(dayXpath);
		util.Click(dayValue);

	}

	public static void performSendKeysOperations(String firstName, String firstNameValue, String lastName,
			String lastNameValue, String userSubmitBtn) {
		util.Sendkeys(firstName, firstNameValue);
		util.Sendkeys(lastName, lastNameValue);
		util.Click(userSubmitBtn);
	}

	@AfterMethod
	public static void closeApplication() {
		util.closeWindow();
	}

}
