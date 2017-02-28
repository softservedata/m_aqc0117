package com.softserve.edu.hw8my;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testSchoolSite {
	
	private final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss";	
	private WebDriver driver; 
	private boolean isTestPassed;

 
	  @BeforeMethod
	  public void beforeMethod() {
		driver.get("https://www.w3schools.com/js/js_ajax_intro.asp");	
		isTestPassed = false;
	  }

	  @AfterMethod
	  public void afterMethod() throws IOException {
		  if (!isTestPassed) {
				String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
		        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		        FileUtils.copyFile(scrFile, new File("./screenshots/" + currentTime + "_screenshot.png"));
			} 
	  }
	  
	  @BeforeClass
	  public void beforeClass() {
		  System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }

	  @AfterClass
	  public void afterClass() {
		  driver.quit();
	  }

	    
	  @Test
	  public void checkChangeContentButton() {
		  
		  final String defaultlabel = "Let AJAX change this text"; 
		  final String changedlabel = "AJAX is not a programming language."
		  		+ "AJAX is a technique for accessing web servers from a web page."
		  		+ "AJAX stands for Asyncronous JavaScript And XML.";
			
		  //Verification
		  Assert.assertEquals(driver.findElement(By.cssSelector("#demo h2")).getText().trim(), defaultlabel);;
		  		  
		  //Steps
		  driver.findElement(By.tagName("button")).click();
	        
		  //Verification
		  List<WebElement> newstring = driver.findElements(By.cssSelector("#demo p"));
		  Assert.assertEquals(newstring.get(0).getText().trim() + newstring.get(1).getText().trim() + newstring.get(2).getText().trim(), changedlabel);
		  isTestPassed = true;
		  		  
	  }

	
	

}
