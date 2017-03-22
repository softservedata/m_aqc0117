package com.softserve.edu.regres.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.regres.data.IUser;
import com.softserve.edu.regres.data.UserRepository;
import com.softserve.edu.regres.pages.AdminHomePage;
import com.softserve.edu.regres.pages.LoginPage;
import com.softserve.edu.regres.pages.SettingsPage;

public class RegisterButtonTest {

	@DataProvider(parallel = true)
	public Object[][] validAdmin() {
		return new Object[][] { 
			{ UserRepository.get().adminWork() },
		};
	}

	@Test(dataProvider = "validAdmin")
	public void checkAdminLogin(IUser admin) throws Exception {
		// Precondition.
		System.setProperty("webdriver.chrome.driver",
		//		"./lib/chromedriver.exe");
				RegisterButtonTest.class.getResource("/lib/chromedriver.exe").getPath().substring(1));
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-proxy-server");
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new ChromeDriver(options);
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.get("http://registrator.herokuapp.com/login");
		driver.get("http://regres.herokuapp.com/login");
		Thread.sleep(2000);
		//
		// Test steps.
		LoginPage loginPage = new LoginPage(driver);
		//LoginPage loginPage = Application.get(applicationSources).load();
		//LoginPage loginPage = Application.get().load();
		Thread.sleep(1000);
		//
		AdminHomePage adminHomePage = loginPage.successAdminLogin(admin);
		Thread.sleep(1000);
		//
		// Goto SettingsPage
		SettingsPage settingsPage = adminHomePage.gotoSettingsPage();
		Thread.sleep(1000);
		//
		// Change setting Personal registration
		settingsPage = settingsPage.gotoPersonalRegistration();
		Thread.sleep(1000);
		//
		// Check.
		Assert.assertTrue(settingsPage.isSettingSaved());
		Assert.assertEquals(settingsPage.getSettingSavedText(),
				SettingsPage.SettingsPageL10n.SETTING_SAVED_MESSAGE
					.getLocalization(settingsPage.getSelectedLanguage()));
		Thread.sleep(1000);
		//
		// Test steps.
		// Logout
		loginPage = settingsPage.logout();
		Thread.sleep(1000);
		//
		// Check.
		// Check exist or not Button on LoginPage
		Assert.assertTrue(loginPage.isRegisterExist());
		Thread.sleep(1000);
		//
		// Test steps.
		settingsPage = loginPage.successAdminLogin(admin).gotoSettingsPage();
		Thread.sleep(1000);
		//
		// Change setting Personal registration
		settingsPage = settingsPage.gotoManualRegistration();
		Thread.sleep(1000);
		//
		// Check.
		Assert.assertTrue(settingsPage.isSettingSaved());
		Assert.assertEquals(settingsPage.getSettingSavedText(),
				SettingsPage.SettingsPageL10n.SETTING_SAVED_MESSAGE
					.getLocalization(settingsPage.getSelectedLanguage()));
		Thread.sleep(1000);
		//
		// Test steps.
		// Logout
		loginPage = settingsPage.logout();
		Thread.sleep(1000);
		//
		// Check.
		// Check exist or not Button on LoginPage
		Assert.assertFalse(loginPage.isRegisterExist());
		Thread.sleep(2000);
		//
		// Return to previous state.
		driver.quit();
	}

}