package com.softserve.edu.hw7my;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class L10n {

	  		@DataProvider
	  		public Object[][] TestData() {
	  			return new Object[ ][ ]{
					{ "uk", "Увійти" }, 
	                { "ru", "Войти" },   
	                { "en", "Sign in" } };  
	  		}
	
	  		@Test(dataProvider="TestData")
	  		public void testLogin(String locale, String translation) throws Exception {
		
		   
			// Precondition
			System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("http://regres.herokuapp.com/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//Test Steps
			new Select(driver.findElement(By.id("changeLanguage"))).selectByValue(locale);
						
			//Check
			Assert.assertEquals(driver.findElement(By.cssSelector("button.btn.btn-primary")).getText().trim(), translation);
			Thread.sleep(5000);
		
			//After Test
			driver.quit();

	}
	
}
