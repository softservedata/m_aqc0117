package com.softserve.edu.selen;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LocalizationTest {

	@DataProvider//(parallel = true)
	public Object[][] loginPageLocalization() {
		return new Object[][] { { "english", new String[] {"Login", "Sign in"} },
			{ "українська", new String[] {"Логін", "Увійти"} },
			{ "русский", new String[] {"Логин", "Войти"} }, };
	}

	@Test(dataProvider = "loginPageLocalization")
	public void checkLoginForm(String language, String[] expecteds) throws Exception {
	// Precondition
	System.setProperty("webdriver.chrome.driver",
			"./lib/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	//
	driver.get("http://regres.herokuapp.com/login");
	Thread.sleep(2000);
	//
	// Test Steps
	Select select = new Select(driver.findElement(By.id("changeLanguage")));
	//select.deselectAll();
	//select.selectByVisibleText("english");
	select.selectByVisibleText(language);
	//
	WebElement login = driver.findElement(By.cssSelector(".form-group label[for='inputEmail']"));
	WebElement button = driver.findElement(By.cssSelector("button.btn.btn-primary"));
	//
	// Check
	//Assert.assertEquals("Login", login.getText().trim());
	Assert.assertEquals(expecteds[0], login.getText().trim());
	Assert.assertEquals(expecteds[1], button.getText().trim());
	//
	// Return to previous state
	Thread.sleep(2000);
	driver.quit();
	}
}
