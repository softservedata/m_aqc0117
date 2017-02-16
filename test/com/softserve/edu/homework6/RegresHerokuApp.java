package com.softserve.edu.homework6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegresHerokuApp {

	private WebDriver driver;

	@Test
	public void test() {
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		// System.setProperty("webdriver.gecko.driver","./lib/geckodriver.exe");
		// driver = new FirefoxDriver();

		driver.get("http://regres.herokuapp.com/login");
		driver.findElement(By.id("login")).sendKeys("work");
		driver.findElement(By.id("password")).sendKeys("qwerty");
		driver.findElement(By.cssSelector("form#loginForm button")).click();
		driver.findElement(By.cssSelector("div#header > div.col-md-7.col-xs-12"));
		// String text = driver.findElement(By.cssSelector("div#header
		// button:nth-child(1)")).getText().trim();
		Assert.assertEquals(driver.findElement(By.cssSelector("div#header button:nth-child(1)")).getText().trim(),
				"work");
		// System.out.println(text);
		driver.quit();
	}

}
