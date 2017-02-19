package com.softserve.edu.hw6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {
	
	@Test
	public void testLogin() throws InterruptedException{
		System.setProperty("webdriver.gecko.driver", "c:/Program Files/Java/selenium-java-3.0.1/lib/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://regres.herokuapp.com/login");
		driver.findElement(By.id("login")).sendKeys("work");
		driver.findElement(By.id("password")).sendKeys("qwerty");
		driver.findElement(By.cssSelector(".btn-primary")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("button.btn.btn-primary.btn-sm")).getText(), "work");
		WebElement dropdown = driver.findElement(By.cssSelector("button.btn.btn-primary.btn-sm.dropdown-toggle"));
		new Actions(driver).clickAndHold(dropdown).build().perform();
		Thread.sleep(4000);
//		driver.findElement(By.linkText("Вихід")).click();
//		Assert.assertEquals(driver.findElement(By.cssSelector("button.btn.btn-primary")).getText(), "Увійти");
		
		driver.quit();
	
	}
}
