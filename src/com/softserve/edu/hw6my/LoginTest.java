package com.softserve.edu.hw6my;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

  @Test
  public void testLogin() throws Exception {
	  
		// Precondition
		System.setProperty("webdriver.gecko.driver", "./lib/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://regres.herokuapp.com/");
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("login")).sendKeys("work");
		driver.findElement(By.id("password")).sendKeys("qwerty");
		driver.findElement(By.cssSelector("button.btn")).click();
		Thread.sleep(5000);
		Assert.assertEquals(driver.findElement(By.cssSelector("#header > div.col-md-5.col-xs-12.hcontrollers > div.col-md-7.col-xs-6.hprofile > div > button:nth-child(1)")).getText(), "work");
		Thread.sleep(5000);
		driver.quit();
  }

  
}