package com.softserve.edu.regres.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.regres.apps.ApplicationSources;
import com.softserve.edu.regres.apps.ApplicationSourcesRepository;
import com.softserve.edu.regres.data.IUser;
import com.softserve.edu.regres.data.UserRepository;
import com.softserve.edu.regres.pages.AdminHomePage;
import com.softserve.edu.regres.pages.Application;
import com.softserve.edu.regres.pages.LoginPage;
import com.softserve.edu.regres.pages.SettingsPage;

public class RegisterButtonApplTest {

	@DataProvider//(parallel = true) // Not parallel 
	public Object[][] validAdmin() {
		return new Object[][] { 
			{ ApplicationSourcesRepository.getChromeOptionsHeroku(),
				UserRepository.get().adminWork() },
		};
	}

	@Test(dataProvider = "validAdmin")
	public void checkAdminLogin(ApplicationSources applicationSources, IUser admin) throws Exception {
		// Precondition.
		//
		// Test steps.
		//LoginPage loginPage = new LoginPage(driver);
		LoginPage loginPage = Application.get(applicationSources).load();
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
		Application.remove();
	}

}
