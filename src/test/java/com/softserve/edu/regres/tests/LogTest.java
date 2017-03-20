package com.softserve.edu.regres.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.regres.data.IUser;
import com.softserve.edu.regres.data.UserRepository;
import com.softserve.edu.regres.pages.LoginPageFactory;

public class LogTest {

	@DataProvider //(parallel = true)
	public Object[][] invalidUsers() {
		return new Object[][] {
			{ UserRepository.get().adminWork() },
		};
	}

	@Test(dataProvider = "invalidUsers")
	public void checkInvalidLog(IUser invalidUser) throws Exception {
		// Precondition
//		System.setProperty("webdriver.gecko.driver",
//				LogTest.class.getResource("/lib/geckodriver.exe").getPath().substring(1));
//		WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver",
		//		"./lib/chromedriver.exe");
				I18nParallelTest.class.getResource("/lib/chromedriver.exe").getPath().substring(1));
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-proxy-server");
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new ChromeDriver(options);
		//
		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
		driver.get("http://regres.herokuapp.com/login");
		//
		// Steps
		LoginPageFactory logPage = new LoginPageFactory(driver); // 1st item
		//LoginPageFactory logPage = PageFactory.initElements(driver, LoginPageFactory.class); // 2nd item
		//
		Thread.sleep(2000);
		logPage.setLoginInput("Ha-Ha-Ha");
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		logPage.setLoginInput("work");
		//
		// Check
		//
		// Return to previous state
		Thread.sleep(2000);
		driver.quit();
	}

}
