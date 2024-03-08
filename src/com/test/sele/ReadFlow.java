package com.test.sele;

import java.io.IOException;

//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class ReadFlow {
	
		WebDriver driver;

		@BeforeTest
		public void beforeTest() throws IOException {
		//System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
	   System.setProperty("WebDriver.chrome.driver", "C:/Users/AJOHNMAR/Downloads/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}

//		@Test
//		public void testAut() throws InterruptedException, IOException, ParseException {
//		readWriteJSON();
//		}

		@AfterTest
		public void afterTest() {
		driver.close();
		}

		public String login(String username, String password) throws InterruptedException {
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.name("Email")).sendKeys(username);
		driver.findElement(By.name("Password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@class='button-1 login-button' and @value='Log in']")).click();

		if(driver.findElements(By.xpath("//input[@id='vote-poll-1']")).size()>0)
		{
		String uname = driver.findElement(By.xpath("//a[@href='/customer/info']")) .getText();
		if(uname.equals(username))
		driver.findElement(By.xpath("//a[@href='/logout']")).click();
		}
		else 
		{
		driver.findElement(By.xpath("//a[@href='/login']")).click();
		return "Invalid User";
		}
		return "Valid User";
		}

}
