package com.softserve.edu.testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC1 {

	@Test
	public void testTC1() throws Exception {
		
		// Precondition
		System.setProperty("webdriver.gecko.driver", "./lib/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://regres.herokuapp.com/login/");
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Steps
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("work");
		
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("qwerty");
		
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
		Thread.sleep(2000);
		
		driver.quit();
	}

}