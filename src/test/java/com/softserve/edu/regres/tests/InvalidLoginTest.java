package com.softserve.edu.regres.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.regres.data.IUser;
import com.softserve.edu.regres.data.UserRepository;
import com.softserve.edu.regres.pages.Application;
import com.softserve.edu.regres.pages.LoginPage;
import com.softserve.edu.regres.pages.LoginValidatorPage;
import com.softserve.edu.regres.pages.ATopPage.ChangeLanguageFields;
import com.softserve.edu.regres.pages.LoginValidatorPage.LoginValidatorPageL10n;

public class InvalidLoginTest extends TestRunner {

	@DataProvider // (parallel = true) // Not parallel
	public Object[][] invalidUser() {
		return new Object[][] { 
			{ UserRepository.get().invalidUser(), ChangeLanguageFields.ENGLISH },
//			{ UserRepository.get().invalidUser(), ChangeLanguageFields.RUSSIAN },
//			{ UserRepository.get().invalidUser(), ChangeLanguageFields.UKRAINIAN },
		};
	}

	@Test(dataProvider = "invalidUser")
	public void checkInvalidLogin(IUser invalidUser, ChangeLanguageFields language) throws Exception {
		// Precondition.
		//
		// Test steps.
		LoginPage loginPage = Application.get().login().changeLanguage(language);
		// LoginPage loginPage = Application.get().load();
		Thread.sleep(1000);
		//
		//LoginValidatorPage loginValidatorPage = Application.get().login().changeLanguage(language).unsuccessfulLogin(invalidUser);
		LoginValidatorPage loginValidatorPage = loginPage.unsuccessfulLogin(invalidUser);
		Thread.sleep(1000);
		//
		// Check.
//		Assert.assertEquals(loginValidatorPage.getValidatorText(),
//				LoginValidatorPageL10n.VALIDATOR_MESSAGE.getLocalization(
//						loginValidatorPage.getSelectedLanguage()));
		Assert.assertEquals(loginValidatorPage.getValidatorText(),
				LoginValidatorPageL10n.VALIDATOR_MESSAGE.getLocalization(language));
		Thread.sleep(1000);
		//
		// Return to previous state.
		// Application.remove();
	}

	//@Test
	public void checkComponent() throws InterruptedException {
		System.out.println("+++checkComponent() DONE");
	}
	
}
