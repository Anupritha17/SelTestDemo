package com.test.assessment;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtilsTest {
	private static WebDriver driver;

	public DriverUtilsTest(WebDriver driver) {
		DriverUtilsTest.driver = driver;
	}

	public void Click(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		By by = By.xpath(xpath);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).click();
	}

	public void Select(String xpath, String option) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		By by = By.xpath(xpath);
		wait.until(ExpectedConditions.elementToBeSelected(by));
		driver.findElement(by).click();
		new Select(driver.findElement(by)).selectByValue(option);

	}

	public void Sendkeys(String xpath, String inputValue) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		By by = By.xpath(xpath);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).sendKeys(inputValue);
	}

	public String GetText(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		By by = By.xpath(xpath);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		return driver.findElement(by).getText();
	}

	public void OpenApplication(String url) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/AJOHNMAR/Downloads/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(url);
	}

	public void closeWindow() {
		driver.quit();
	}
}
