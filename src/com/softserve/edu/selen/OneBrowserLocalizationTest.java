package com.softserve.edu.selen;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OneBrowserLocalizationTest {
	private final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss";
	private WebDriver driver;
	private boolean isTestSuccess;

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		System.out.println("@BeforeMethod");
		isTestSuccess = false;
		driver.get("http://regres.herokuapp.com/login");
		Thread.sleep(2000);
	}

	@AfterMethod
	public void afterMethod() throws IOException {
		System.out.println("@AfterMethod");
		if (!isTestSuccess) {
			String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
	        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(scrFile, new File("./" + currentTime + "_screenshot.png"));
		}
		// Return to previous state
		//driver.get("http://regres.herokuapp.com/logout");
	}

	@BeforeClass
	public void beforeClass() throws InterruptedException {
		System.out.println("@BeforeClass");
		// Precondition
		System.setProperty("webdriver.chrome.driver",
				"./lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		System.out.println("@AfterClass");
		// Return to previous state. Close Browser
		Thread.sleep(2000);
		driver.quit();
	}

	@DataProvider//(parallel = true)
	public Object[][] loginPageLocalization() {
		return new Object[][] { { "english", new String[] {"Login", "Sign in"} },
			{ "українська", new String[] {"Логін", "Увійти"} },
			{ "русский", new String[] {"Логин", "Войти"} }, };
	}

	@Test(dataProvider = "loginPageLocalization")
	public void checkLoginForm(String language, String[] expecteds) throws Exception {
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
	Assert.assertEquals(login.getText().trim(), expecteds[0]);
	Assert.assertEquals(button.getText().trim(), expecteds[1], "ERROR Found");
	//
	isTestSuccess = true;
	}
}
