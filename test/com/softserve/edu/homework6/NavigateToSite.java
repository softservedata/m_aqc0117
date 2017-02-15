package com.softserve.edu.homework6;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class NavigateToSite {

	private WebDriver driver;

	@Test
	public void test() {
		System.setProperty("webdriver.gecko.driver", "./lib/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.get("https://www.google.com.ua/");
		driver.findElement(By.id("lst-ib")).clear();
		driver.findElement(By.id("lst-ib")).sendKeys("Google");
		driver.findElement(By.name("btnG")).click();
//		driver.close();
		driver.quit();

	}

}
