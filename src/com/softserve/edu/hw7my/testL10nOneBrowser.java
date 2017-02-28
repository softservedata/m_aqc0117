package com.softserve.edu.hw7my;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testL10nOneBrowser {
	private final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss";	
	private WebDriver driver; 
	private boolean isTestPassed;

 
	  @BeforeMethod
	  public void beforeMethod() {
		driver.get("http://regres.herokuapp.com/login");	
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

	  @DataProvider
	  public Object[][] dp_LoginPage() {
	    return new Object[][] {
	      { "uk", new String[] {"Увійти", "Запам'ятати мене", "Пароль"} },
	      { "ru", new String[] {"Войти", "Запомнить меня", "Пароль"} },
	      { "en", new String[] {"Sign in", "Remember me", "Password"} },
	    };
	  }
	  
	  @Test(dataProvider = "dp_LoginPage")
	  public void checkLoginPage(String locale, String [] translation) {
		  
		  //Steps
		  new Select(driver.findElement(By.id("changeLanguage"))).selectByValue(locale);
		  
		  //Verification
		  Assert.assertEquals(driver.findElement(By.cssSelector("button.btn.btn-primary")).getText().trim(), translation[0]);
		  Assert.assertEquals(driver.findElement(By.xpath("//*[@id='_spring_security_remember_me']/..")).getText().trim(), translation[1]);
		  Assert.assertEquals(driver.findElement(By.cssSelector("label[for='inputPassword']")).getText().trim(), translation[2]);
		  isTestPassed = true;
		  
	  }
	
}
