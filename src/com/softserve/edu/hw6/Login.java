package com.softserve.edu.hw6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {
	
	@Test
	public void testFF(){
		WebDriver driver = new FirefoxProvider().setDriver();
		openApp(driver);
		testLocale(driver,"en");
		testLocale(driver,"ru");
		testLocale(driver,"uk");
		driver.quit();
	}
	
	@Test
	public void testChrome(){
		WebDriver driver = new ChromeProvider().setDriver();
		openApp(driver);
		testLocale(driver,"en");
		testLocale(driver,"ru");
		testLocale(driver,"uk");
		driver.quit();
	}
	@Test
	public void testPhantom(){
		WebDriver driver = new PhantomProvider().setDriver();
		openApp(driver);
		testLocale(driver,"en");
		testLocale(driver,"ru");
		testLocale(driver,"uk");
		driver.quit();
	}
	
	public void testLogin(WebDriver driver) {

		
		driver.findElement(By.id("login")).sendKeys("work");
		driver.findElement(By.id("password")).sendKeys("qwerty");
		driver.findElement(By.cssSelector(".btn-primary")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("button.btn.btn-primary.btn-sm")).getText(), "work");
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("button.btn.btn-primary.btn-sm.dropdown-toggle")));
		driver.findElement(By.linkText("Вихід")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("button.btn.btn-primary")).getText(), "Увійти");
		driver.quit();
	
	}
	
	
	public void testLocale(WebDriver driver, String locale){
		localeProvider localeProv = new localeProvider(locale);
		if (!localeProv.getLocale().isEmpty()){
			new Select(driver.findElement(By.id("changeLanguage"))).selectByValue(locale);
			Assert.assertEquals(new Select(driver.findElement(By.id("changeLanguage"))).
					getFirstSelectedOption().getText(), localeProv.getName());
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id='loginForm']/div[2]/label")).getText(), localeProv.getLogin());
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id='loginForm']/div[3]/label")).getText(), localeProv.getPassword());
			Assert.assertEquals(driver.findElement(By.xpath("//*[@class='container-fluid']/div[1]")).getText().replaceAll("\n", " "),localeProv.getTitle());
			
		}
	}
	
	public void openApp(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://regres.herokuapp.com/login");
	}
	
	
}
