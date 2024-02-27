package com.test.sele;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ajio {
	public static void main(String[] args) {
		// WebDriverManager.chromedriver.setup();
		System.setProperty("webdriver.chrome.driver", "C:/Users/AJOHNMAR/Downloads/chromedriver.exe");
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--disable-notifications");
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//		options.merge(capabilities);
		WebDriver driver = new ChromeDriver();
		//Explicit Web Driver to wait for certain conditions specify the (Expected Conditions) 
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60)); 
		//Implicitly waits element to appear on the page//No Such Element Exception
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.ajio.com");
		driver.manage().window().maximize();
		
		String parentHandel=driver.getWindowHandle();
		System.out.println("parent window current window "+ parentHandel);
		driver.findElement(By.xpath("//div[@id='closeBtn']")).click();
		WebElement search = driver.findElement(By.xpath("//input[@aria-label='Search Ajio']"));
		search.sendKeys("Travelbag");
		//search.sendKeys(Keys.ENTER);
		System.out.println(driver.getTitle());
		System.out.println(driver.findElement(By.xpath("//span[starts-with(@aria-label,'K')]")).getText());
		driver.findElement(By.xpath("//img[contains(@class,'rilrtl-lazy-img')]")).click();
		Set<String> handel=driver.getWindowHandles();//store all the unique string val
		for(String handels:handel) {
			System.out.println("parent and child :"+handels);
			if(!handels.equals(parentHandel)) {
				driver.switchTo().window(handels);
				driver.findElement(By.xpath("//img[contains(@alt,'Wishlist icon')]")).click();
			}
			//driver.switchTo().window(parentHandel);
		}
		driver.findElement(By.xpath("//input[@type='number']")).sendKeys("0000000000");
		WebElement time=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));
		time.click();
		System.out.println(driver.findElement(By.id("error-msg")).getText());
		driver.switchTo().window(parentHandel);
		//WebElement time1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit']")));
		//time1.click();
		//Boolean time1=wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@type='submit']")));
	    //System.out.println(time1.booleanValue());
		
		
		//driver.findElement(By.xpath("//span[contains(@class,'pdp-wishlist-desktop-icon')]")).click();
		//search=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class,'pdp-wishlist-desktop-icon')]")));
		//search=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='btn-gold']")));
		//search=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[contains(@class,'rilrtl-lazy-img')]")));
		//search.click();
		//driver.findElement(By.xpath("//a[@href,'https://www.ajio.com/ajio-own-sale-policy']")).click();
    	//driver.quit();
    	//driver.close();
//
//		System.out.println(driver.findElement(By.xpath("//img[contains(@class,'rilrtl-lazy-img')]")).getText());
//		search.sendKeys("Travelbag for mens");
//		search.sendKeys(Keys.ARROW_DOWN);
//		driver.findElement(By.xpath("//div[@class='btn-cart']")).click();
//		driver.findElement(By.xpath("//span[contains(@class,'ic-pdp-add-cart')]")).click();
//		search = driver.findElement(By.xpath("//div[@class,'btn-cart']"));
//		search.click();
//		search = driver.findElement(By.xpath("//img[contains(@src,'https://assets.ajio.com/static/img/pdp-wishlist-icon-desktop.svg')]"));
//		search.click();
//		driver.findElement(By.className("btn-cart")).click();
//		search.sendKeys(Keys.ENTER);
//		driver.findElement(By.xpath("//h2[@class='prod-heading']//following::li[@class='detail-list']")).getText();
//		driver.findElement(By.xpath("//a[@id='product-details-tab-tab-3']")).click();
//      System.out.println(driver.findElement(By.xpath("//a[@id='product-details-tab-tab-3']")).getText());

	}

}
