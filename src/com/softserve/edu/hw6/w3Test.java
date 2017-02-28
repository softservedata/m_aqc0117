package com.softserve.edu.hw6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class w3Test {

	
	@Test
	public void testFF() {
		WebDriver driver = new FirefoxProvider().setDriver();
		runLocaleTests(driver);
	}

	@Test
	public void testChrome() {
		WebDriver driver = new ChromeProvider().setDriver();
		runLocaleTests(driver);
	}

	@Test
	public void testPhantom() {
		WebDriver driver = new PhantomProvider().setDriver();
		runLocaleTests(driver);
	}



	public void runLocaleTests(WebDriver driver) {
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("AJAX is not a programming language.");
		expected.add("AJAX is a technique for accessing web servers from a web page.");
		expected.add("AJAX stands for Asyncronous JavaScript And XML.");
		openApp(driver);
		Assert.assertEquals(driver.findElement(By.cssSelector("#demo>h2")).getText(), "Let AJAX change this text");
		driver.findElement(By.cssSelector("#demo>button")).click();

		List<WebElement> actuals = driver.findElements(By.cssSelector("#demo>p"));
		for (int i = 0; i< actuals.size(); i++)
			Assert.assertEquals(actuals.get(i).getText(), expected.get(i));
		driver.quit();
	}

	public void openApp(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/js/js_ajax_intro.asp");
	}

}
