package com.softserve.edu.regres.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.Appl;
import com.softserve.edu.regres.data.IUser;
import com.softserve.edu.regres.data.UserRepository;
import com.softserve.edu.regres.pages.Application;
import com.softserve.edu.regres.pages.LoginPage;
import com.softserve.edu.regres.pages.LoginValidatorPage;
import com.softserve.edu.regres.pages.ATopPage.ChangeLanguageFields;
import com.softserve.edu.regres.pages.LoginValidatorPage.LoginValidatorPageL10n;
import com.softserve.edu.regres.tools.ReporterWrapper;

public class InvalidLoginTest extends TestRunner {
	private static final Logger logger = LoggerFactory.getLogger(Appl.class);

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
		logger.info("Begin");
		ReporterWrapper.get().info("Begin checkInvalidLogin()");
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
		testDone();
		ReporterWrapper.get().takeScreen(Application.get().getWebDriver());
		ReporterWrapper.get().info("Done checkInvalidLogin()");
		logger.info("Done");
	}

	//@Test
	public void checkComponent() throws InterruptedException {
		System.out.println("+++checkComponent() DONE");
	}
	
}
