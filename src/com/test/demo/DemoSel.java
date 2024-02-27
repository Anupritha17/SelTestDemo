package com.test.demo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class DemoSel {
	static void ter()  {
		System.setProperty("WebDriver.chrome.driver", "C:/Users/AJOHNMAR/Downloads/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		WebElement search=driver.findElement(By.xpath("//a[@href='reservation.php']"));
		search.click();
		driver.findElement(By.xpath("//input[@value='oneway']")).click();
		Select s1=new Select(driver.findElement(By.xpath("//select[@name='passCount']")));
		s1.selectByValue("3");
		Select s2=new Select(driver.findElement(By.xpath("//select[@name='fromPort']")));
		s2.selectByValue("London");
		Select s3=new Select(driver.findElement(By.xpath("//select[@name='fromMonth']")));
		s3.selectByValue("3");
		Select s4=new Select(driver.findElement(By.xpath("//select[@name='fromDay']")));
		s4.selectByValue("16");
		Select s5=new Select(driver.findElement(By.xpath("//select[@name='toPort']")));
		s5.selectByValue("San Francisco");
		WebElement wb=driver.findElement(By.xpath("//input[@value='First']"));
		wb.click();
		Select s7=new Select(driver.findElement(By.xpath("//select[@name='airline']")));
		s7.selectByVisibleText("Blue Skies Airlines");
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(file, new File("C:/Users/AJOHNMAR/Downloads/sample/ss.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// Take screenshot
//        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//        // Get current timestamp
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
//        String timestamp = dateFormat.format(new Date());
//
//        // Define the file path with the timestamp
//        String filePath = "C:/Users/AJOHNMAR/Downloads/sample/ss_" + timestamp + ".png";
//
//        // Copy the screenshot file to the new location with the timestamped file name
//        try {
//            Path sourcePath = screenshotFile.toPath();
//            Path destinationPath = Paths.get(filePath);
//            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
//            System.out.println("Screenshot saved: " + filePath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

	}
		
	}


