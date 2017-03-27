package com.softserve.edu.regres.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softserve.edu.Appl;

public class LoginValidatorPage extends LoginPage {

	public static enum LoginValidatorPageL10n {
		VALIDATOR_MESSAGE("Неправильний логін або пароль",
				"Неправильный логин или пароль",
				"Wrong login or password");
		//
		private HashMap<ChangeLanguageFields, String> field;

		private LoginValidatorPageL10n(String... localization) {
			this.field = new HashMap<ChangeLanguageFields, String>();
			int i = 0;
			for (ChangeLanguageFields language : ChangeLanguageFields.values()) {
				this.field.put(language, localization[i]);
				i++;
			}
		}

		public String getLocalization(ChangeLanguageFields language) {
			return this.field.get(language).trim();
		}
	}

	
	// Fields
	
	private static final Logger logger = LoggerFactory.getLogger(LoginValidatorPage.class);
	//
	private WebElement validator;

	public LoginValidatorPage(WebDriver driver) {
		super(driver);
		this.validator = driver.findElement(By.xpath("//div[@style='color: red;']"));
	}

	// PageObject

	// get Data

	public WebElement getValidator() {
		logger.debug("getValidator() Done");
		return this.validator;
	}

	// Functional

	public String getValidatorText() {
		logger.debug("getValidatorText() Done");
		return getValidator().getText();
	}

	public String getStartValidatorText(ChangeLanguageFields language) {
		return getValidatorText().substring(0, LoginValidatorPageL10n.VALIDATOR_MESSAGE
				.getLocalization(language).length());
	}

	// set Data

	// Business Logic

}
