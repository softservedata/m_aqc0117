package com.softserve.edu.selen;

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
		driver.get("https://www.google.com.ua/");
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//
		// Test steps
		// Best practice
		//driver.findElement(By.id("lst-ib")).clear();
		//driver.findElement(By.id("lst-ib")).sendKeys("selenium ide");
		//
		// Don't use local variable!
		By googleFindById = By.id("lst-ib");
		WebElement googleFindElement = driver.findElement(googleFindById);
		googleFindElement.clear();
		googleFindElement.sendKeys("selenium ide");
		Thread.sleep(1000);
		//
		driver.findElement(By.id("_fZl")).click();
		driver.findElement(By.linkText("Selenium IDE Plugins")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Download")).click();
		Thread.sleep(1000);
		//driver.findElement(By.id("close")).click();
		//
		// Check
		//By actualFind = By.name("side_plugins");
//		By actualFind = By.cssSelector("p a[name='side_plugins']");
//		WebElement actualFindElement = driver.findElement(actualFind);
//		String actualFindText= actualFindElement.getText().trim();
//		String expected = "Selenium IDE can be extended through its own plugin system. Here are a number of plugins that have been created using it. For more information on how to create your own plugin or have it listed, see the";
//		System.out.println("actualFindText" + actualFindText);
//		System.out.println("expected" + expected);
//		Assert.assertEquals(actualFindText, expected);
		Assert.assertEquals(driver.findElement(By.cssSelector("p a[name='side_plugins']")).getText().trim(),
				"Selenium IDE can be extended through its own plugin system. Here are a number of plugins that have been created using it. For more information on how to create your own plugin or have it listed, see the");
		//
		// Never use Thread.sleep()
		Thread.sleep(4000);
		//driver.close();
		driver.quit();
	}

}
