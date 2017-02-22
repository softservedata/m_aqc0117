package com.softserve.edu.selen;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

	//@Test
	public void checkAdminLogin() throws Exception {
		// Precondition
		//System.setProperty("webdriver.gecko.driver",
		//		"./lib/geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver",
				"./lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//
		driver.get("http://regres.herokuapp.com/login");
		Thread.sleep(2000);
		//
		// Test Steps
		//
		/* - Code Smell
		// Variant 1
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		login.clear();
		login.sendKeys("hahaha");
		Thread.sleep(2000);
		//
		driver.navigate().refresh();
		login.sendKeys("work"); // ERROR !!!
		*/
		//
		// Variant 2
		driver.findElement(By.id("login")).click();
		driver.findElement(By.id("login")).clear();
		driver.findElement(By.id("login")).sendKeys("hahaha");
		Thread.sleep(2000);
		//
		driver.navigate().refresh();
		driver.findElement(By.id("login")).sendKeys("work"); // No Error
		//
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("qwerty");
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
		//
		// Check
		Assert.assertEquals(driver.findElement(By
				.xpath("//button[@class='btn btn-primary btn-sm']")).getText(), "work");
		//
		// Return to previous state
		driver.findElement(By.cssSelector("button.btn.btn-primary.btn-sm.dropdown-toggle")).click();
		driver.findElement(By.xpath("//a[contains(@href,'/logout')]")).click();
		//driver.get("http://regres.herokuapp.com/logout");
		//
		// Check
		Assert.assertTrue(driver.findElements(By.id("login")).size() > 0);
		Thread.sleep(2000);
		driver.quit();
	}

	//@Test
	public void checkLocalVariable() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"./lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//
		driver.get("http://schedule-lv215.herokuapp.com");
		driver.findElement(By.cssSelector("#ch1_chosen > a.chosen-single > span")).click();
		//
		// Do not use local variable
		WebElement search = driver.findElement(By.cssSelector("div.chosen-drop > div.chosen-search > input"));
		//
		// Do not work.
		//search.sendKeys("Room 202");
		//search.click();
		//
		// Use KeyBoard
		search.sendKeys("Room 202" + Keys.ENTER);
		// After Enter WebElement search not Visible 
		//search.click(); // ERROR
		//
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button.fc-prev-button.fc-button.fc-state-default.fc-corner-left")).click();
		// driver.findElement(By.xpath("//button[@class='fc-prev-button
		// fc-button fc-state-default fc-corner-left']")).click();
		//
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void checkMoveScroll() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"./lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//
		driver.get("http://www.seleniumhq.org/download/");
		//WebElement seleniumIDE = driver.findElement(By.name("selenium_ide"));
		WebElement seleniumIDE =driver.findElement(By.partialLinkText("plugin tutorial page"));
		//WebElement seleniumIDE =driver.findElement(By.partialLinkText("see the wiki page"));
		//
		// Scrolling
		(new Actions(driver)).moveToElement(seleniumIDE).perform();
		Thread.sleep(2000);
		//
		// Set Focus
		//seleniumIDE.sendKeys(new String());
		seleniumIDE.sendKeys("");
		Thread.sleep(2000);
		//
		seleniumIDE.sendKeys("" + Keys.ENTER);
		//
		// Do not work
		//new Actions(driver).moveToElement(seleniumIDE).sendKeys(Keys.ENTER);
		//new Actions(driver).moveToElement(seleniumIDE).sendKeys(Keys.TAB);
		//new Actions(driver).sendKeys(Keys.ENTER);
		//new Actions(driver).sendKeys(Keys.TAB);
	}
}