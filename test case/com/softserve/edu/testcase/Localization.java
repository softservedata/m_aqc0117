package com.softserve.edu.testcase;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Localization {
	@DataProvider
		public Object[][] TestData() {
			return new Object[ ][ ]{
			{ "uk", "Увійти" }, 
            { "ru", "Войти" },   
            { "en", "Sign in" } };  
		}

		@Test
		(dataProvider="TestData")
		public void testLogin(String locale, String translation) throws Exception {

   
	// Precondition
	System.setProperty("webdriver.gecko.driver", "./lib/geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.get("http://regres.herokuapp.com/login/");
	Thread.sleep(1000);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	//Test Steps
	new Select(driver.findElement(By.id("changeLanguage"))).selectByValue(locale);
	Thread.sleep(9000);			
	//Check
	Assert.assertEquals(driver.findElement(By.cssSelector("button.btn.btn-primary")).getText().trim(), translation);
	Thread.sleep(5000);

	//After Test
	driver.quit();

}
}
