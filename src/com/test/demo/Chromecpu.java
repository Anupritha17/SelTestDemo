package com.test.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chromecpu {
    public static void main(String[] args) {
        // Set the path for ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:/Users/AJOHNMAR/Downloads/chromedriver.exe");
        
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        
        // Navigate to the URL
        driver.get("https://practice.expandtesting.com/dynamic-table");
        
        // Retrieve Chrome CPU value from table
        WebElement tableCell = driver.findElement(By.xpath("//td[contains(text(),'Chrome')]/following-sibling::td[1]"));
        String tableCellValue = tableCell.getText();
        System.out.println("Chrome CPU value from table: " + tableCellValue);
        
        // Retrieve Chrome CPU value from the highlighted section below table
        WebElement highlightedCell = driver.findElement(By.xpath("//p[@id='chrome-cpu']"));
        String highlightedCellValue = highlightedCell.getText();
        System.out.println("Chrome CPU value from highlighted section: " + highlightedCellValue);
        
        // Check whether both values are the same
        if (tableCellValue.equals(highlightedCellValue)) {
            System.out.println("Both values are the same.");
        } else {
            System.out.println("Values are different.");
        }
        
        // Close the browser
        driver.quit();
    }
}

