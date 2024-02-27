package com.test.demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SETC {
	public static void main(String[] args) {
		System.setProperty("Webdriver.chrome.driver", "C:/Users/AJOHNMAR/Downloads/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.tnstc.in/home.html");
		
		//To send the text using ExecuteScript
		js.executeScript("document.getElementById('matchStartPlace').value='KRISHNAGIRI';");
		js.executeScript("document.getElementById('matchEndPlace').value='BANGALORE';");
		
		//Window handle
//		String parentHandel=driver.getWindowHandle();
//		System.out.println("parent window current window "+ parentHandel);
//		WebElement fromTextBox = driver.findElement(By.xpath("//input[@id='matchStartPlace']"));
//		fromTextBox.sendKeys("KRISHNAGIRI");
//		fromTextBox.sendKeys(Keys.ARROW_DOWN);
//		fromTextBox.sendKeys(Keys.ENTER);
// 
//		WebElement toTextBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='matchEndPlace']")));
//		toTextBox.sendKeys("BANGALORE");
//		toTextBox.sendKeys(Keys.ARROW_DOWN);
//		toTextBox.sendKeys(Keys.ENTER);
//		toTextBox.sendKeys(Keys.TAB);
		
		WebElement date = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='txtdeptDateOtrip']")));
    	date.click();
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='ui-datepicker-calendar']"))).click();
    	
    	
    	//Select method Select class-ordinary class 
    	//so New keyword used create its object, web element location.
    	Select S = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		S.selectByValue("1");
		
    	WebElement dates = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='2'8]")));
    	dates.click();
    	//dates.sendKeys(Keys.TAB);
    	Select time = new Select(driver.findElement(By.xpath("//select[@id='selectOnwardTimeSlab']")));
		time.selectByValue("00:00-12:00");
		WebElement female2 = driver.findElement(By.xpath("//input[@id='txtAdultFemales']"));
        female2.sendKeys("1");
        WebElement Search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='SEARCH']")));
		Search.click();
		
		
		//Alert iframe switchto
		String alertMessage = driver.switchTo().alert().getText();
		System.out.print(alertMessage);
		//driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'newsItems.html')]")));
		//WebElement Element = driver.findElement(By.xpath("//img[@src='images/top-places/td_01.jpg']"));
        //This will scroll the page till the element is found		
        //js.executeScript("arguments[0].scrollIntoView();", Element);
		//js.executeScript("window.scrollBy(0,150)");
		driver.findElement(By.xpath("//a[@href='https://www.tnstc.in/SETCPG/preGatewayTransactionStatus.do?hiddenAction=CheckRefundStatus']")).click();
		//MouseOver
		Actions actions=new Actions(driver);
	    WebElement ms=driver.findElement(By.xpath("//a[@class='homebtn left']"));
	    actions.moveToElement(ms).perform();
	    //actions
	    js.executeScript("window.scrollBy(0,150)");
		//driver.switchTo().window(parentHandel);
//		Set<String> handel=driver.getWindowHandles();//store all the unique string val
//		for(String handels:handel) {
//			System.out.println("parent and child :"+handels);
//			if(!handels.equals(parentHandel)) {
//				driver.switchTo().window(handels);
//				driver.findElement(By.xpath("//a[@href='https://www.tnstc.in/SETCPG/preGatewayTransactionStatus.do?hiddenAction=CheckRefundStatus']")).click();
//			}
//			driver.switchTo().window(parentHandel);
//		}
		
		
		
		
     	//actions.moveToElement(ms).perform();
//		WebElement validation=driver.findElement(By.xpath("//a[@href='https://www.tnstc.in/SETCWeb']"));
//		boolean isvalidate=validation.isDisplayed();
//		if(isvalidate) {
//			System.out.println("Validation done");
//		}else {
//			System.out.println("Validation is not done");
//		}
//		
		
		
		
		
		
    	
//    	Select S = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
//		S.selectByValue("Mar");
//		js.executeScript("document.getElementById('ui-datepicker-div').value='25';");
//		WebElement Date = driver.findElement(By.xpath("//td[@data-handler='selectDay']//a[text()='25']"));
//		Date.click();
		
		
		
//		Select s1=new Select(driver.findElement(By.xpath("//ul[@id='ui-id-1']//following::a[@class='ui-corner-all']")));
//		s1.selectByVisibleText("KRISHNAGIRI");
//		WebElement fromTextBox = driver.findElement(By.xpath("//input[@id='matchStartPlace']"));
//		fromTextBox.sendKeys("KRISHNAGIRI");
//		fromTextBox.sendKeys(Keys.ARROW_DOWN);
//		fromTextBox.sendKeys(Keys.ENTER);
// 
//		WebElement toTextBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='matchEndPlace']")));
//		toTextBox.sendKeys("BANGALORE");
//		toTextBox.sendKeys(Keys.ARROW_DOWN);
//		toTextBox.sendKeys(Keys.ENTER);
		
//		WebElement date = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='txtdeptDateOtrip']")));
//    	date.sendKeys(Keys.TAB);
//    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='ui-datepicker-calendar']")));
//
//		Select S = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
//		S.selectByVisibleText("Feb");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		
//		WebElement Date = driver.findElement(By.xpath("//td[@data-handler='selectDay']//a[text()='25']"));
//		Date.click();
		
		//selecting the month
//				WebElement MonthTab = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
//				Select S = new Select(MonthTab);
//				S.selectByVisibleText("Mar");
//				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//				//selecting the date
//				WebElement Date = driver.findElement(By.xpath("//td[@data-handler='selectDay']//a[text()='15']"));
//				Date.click();
//
//		WebElement datee = driver.findElement(By.xpath("//td[@data-handler='selectDay']//a[text()='27']"));
//		datee.click();
//		
		
//		WebElement female = driver.findElement(By.xpath("//input[@id='txtAdultMales']"));
//		female.clear();
//		
//		WebElement female2 = driver.findElement(By.xpath("//input[@id='txtAdultFemales']"));
//	    female2.sendKeys("1");
////		// search element
//		WebElement Search = driver.findElement(By.xpath("//div[@class='btnTxt']//a[text()='SEARCH']"));
//		Search.click();

	}

}
