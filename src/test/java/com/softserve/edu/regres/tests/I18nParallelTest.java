package com.softserve.edu.regres.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.regres.pages.ATopPage.ChangeLanguageFields;
import com.softserve.edu.regres.pages.LoginPage;
import com.softserve.edu.regres.pages.LoginPage.LoginPageL10n;

public class I18nParallelTest {

	@DataProvider(parallel = true)
	public Object[][] localization() {
		return new Object[][] {
			{ ChangeLanguageFields.RUSSIAN },
			{ ChangeLanguageFields.UKRAINIAN },
			{ ChangeLanguageFields.ENGLISH } };
	}

	@Test(dataProvider = "localization")
	public void checkLocalization(ChangeLanguageFields language) throws Exception {
		// Precondition
		// TODO Remove from test
		// WebDriver driver = new FirefoxDriver();
//		System.setProperty("webdriver.chrome.driver",
//				this.getClass().getResource("/lib/chromedriver.exe").getPath().substring(1));
		System.setProperty("webdriver.chrome.driver",
				"./lib/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-proxy-server");
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.get("http://registrator.herokuapp.com/login");
		driver.get("http://regres.herokuapp.com/login");
		Thread.sleep(4000);
		//
		// Steps
		LoginPage loginPage = new LoginPage(driver);
		// Must be Deleted
		Thread.sleep(2000);
		loginPage = loginPage.changeLanguage(language);
		//
		// Check
		Assert.assertEquals(loginPage.getLoginLabelText(),
				LoginPageL10n.LOGIN_LABEL.getLocalization(language));
		Assert.assertEquals(loginPage.getPasswordLabelText(),
				LoginPageL10n.PASSWORD_LABEL.getLocalization(language));
		Assert.assertEquals(loginPage.getSignintText(),
				LoginPageL10n.SUBMIT_BUTTON.getLocalization(language));
		Thread.sleep(5000);
		//
		// Return to previous state
		driver.quit();
	}

}