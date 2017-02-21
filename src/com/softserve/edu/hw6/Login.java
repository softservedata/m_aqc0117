package com.softserve.edu.hw6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {
	
	@Test
	public void testFF(){
		WebDriver driver = new FirefoxProvider().setDriver();
		testLogin(driver);
	}
	
	@Test
	public void testChrome(){
		WebDriver driver = new ChromeProvider().setDriver();
		testLogin(driver);
	}
	@Test
	public void testPhantom(){
		WebDriver driver = new PhantomProvider().setDriver();
		testLogin(driver);
	}
	
	public void testLogin(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://regres.herokuapp.com/login");
		driver.findElement(By.id("login")).sendKeys("work");
		driver.findElement(By.id("password")).sendKeys("qwerty");
		driver.findElement(By.cssSelector(".btn-primary")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("button.btn.btn-primary.btn-sm")).getText(), "work");
		driver.findElement(By.cssSelector("button.btn.btn-primary.btn-sm.dropdown-toggle")).click();
		driver.findElement(By.linkText("Вихід")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("button.btn.btn-primary")).getText(), "Увійти");
		driver.quit();
	
	}
}
