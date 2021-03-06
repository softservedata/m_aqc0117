package com.softserve.edu.regres.pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.regres.data.IUser;
import com.softserve.edu.regres.tools.GeneralRegresException;

public class LoginPage extends ATopPage {
	//
	private static final String REGISTER_ERROR = "Button Register not Found";
	// public static final Logger logger =
	// LoggerFactory.getLogger(LoginPage.class);
	//
	// Expected text
	public static final String SRC_ATTRIBUTE = "src";
	public static final String NAME_IMAGE = "ukraine_logo2.gif";
	//
	// Locators
	private static final String LOGIN_LABEL_XPATH = "//label[contains(@for,'inputEmail')]";
	private static final String LOGIN_INPUT_ID = "login";
	private static final String PASSWORD_LABEL_XPATH = "//label[contains(@for,'inputPassword')]";
	private static final String PASSWORD_INPUT_ID = "password";
	private static final String SIGNIN_BUTTON_CSSSELECTOR = "button.btn.btn-primary";
	private static final String LOGO_CSSSELECTOR = "img.login_logo.col-md-8.col-xs-12";
	private static final String REGISTER_BUTTON_CSSSELECTOR = "a.btn.btn-success";

	public static enum LoginPageL10n {
		LOGIN_LABEL("����", "�����", "Login"), PASSWORD_LABEL("������", "������", "Password"), SUBMIT_BUTTON("�����",
				"�����", "Sign in");
		//
		private HashMap<ChangeLanguageFields, String> field;

		private LoginPageL10n(String... localization) {
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

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	// Fields
	// private WebDriver driver;
	//
	// private WebElement loginLabel;
	// private WebElement loginInput;
	// private WebElement passwordLabel;
	// private WebElement passwordInput;
	// private WebElement signin;
	// private WebElement logo;
	//
	private List<WebElement> register;

	public LoginPage(WebDriver driver) {
		super(driver);
		// this.driver = driver;
		//
		// this.loginLabel = driver.findElement(By.xpath(LOGIN_LABEL_XPATH));
		// this.loginInput = driver.findElement(By.id(LOGIN_INPUT_ID));
		// this.passwordLabel =
		// driver.findElement(By.xpath(PASSWORD_LABEL_XPATH));
		// this.passwordInput = driver.findElement(By.id(PASSWORD_INPUT_ID));
		// this.signin =
		// driver.findElement(By.cssSelector(SIGNIN_BUTTON_CSSSELECTOR));
		// this.logo = driver.findElement(By.cssSelector(LOGO_CSSSELECTOR));
	}

	// PageObject

	// get Data

	public WebElement getLoginLabel() {
		// return this.loginLabel;
		return driver.findElement(By.xpath(LOGIN_LABEL_XPATH));
	}

	public WebElement getLoginInput() {
		// logger.debug("Start");
		// return this.loginInput;
		return driver.findElement(By.id(LOGIN_INPUT_ID));
	}

	public WebElement getPasswordLabel() {
		// return this.passwordLabel;
		return driver.findElement(By.xpath(PASSWORD_LABEL_XPATH));
	}

	public WebElement getPasswordInput() {
		// logger.debug("Start");
		// return this.passwordInput;
		return driver.findElement(By.id(PASSWORD_INPUT_ID));
	}

	public WebElement getSignin() {
		// logger.debug("Start");
		// return this.signin;
		return driver.findElement(By.cssSelector(SIGNIN_BUTTON_CSSSELECTOR));
	}

	public WebElement getLogo() {
		// return this.logo;
		return driver.findElement(By.cssSelector(LOGO_CSSSELECTOR));
	}

	public boolean isRegisterExist() {
		register = driver.findElements(By.cssSelector(REGISTER_BUTTON_CSSSELECTOR));
		return register.size() > 0;
	}

	public WebElement getRegister() {
		if (!isRegisterExist()) {
			throw new GeneralRegresException(REGISTER_ERROR);
		}
		return register.get(0);
	}

	// Functional

	public String getLoginLabelText() {
		return getLoginLabel().getText().trim();
	}

	public String getLoginInputText() {
		return getLoginInput().getText();
	}

	public String getPasswordLabelText() {
		return getPasswordLabel().getText().trim();
	}

	public String getPasswordInputText() {
		return getPasswordInput().getText();
	}

	public String getSignintText() {
		return getSignin().getText().trim();
	}

	public String getLogoAttributeText(String attribute) {
		return getLogo().getAttribute(attribute).trim();
	}

	public String getLogoAttributeSrcText() {
		return getLogoAttributeText(SRC_ATTRIBUTE);
	}

	public String getRegisterText() {
		return getRegister().getText().trim();
	}

	// set Data

	public void setLoginInput(String login) {
		getLoginInput().sendKeys(login);
	}

	public void setLoginInputClear(String login) {
		clearLoginInput();
		setLoginInput(login);
	}

	public void setPasswordInput(String password) {
		getPasswordInput().sendKeys(password);
	}

	public void setPasswordInputClear(String password) {
		clearPasswordInput();
		setPasswordInput(password);
	}

	public void clearLoginInput() {
		getLoginInput().clear();
	}

	public void clearPasswordInput() {
		getPasswordInput().clear();
	}

	public void clickLogin() {
		getLoginInput().click();
	}

	public void clickPassword() {
		getPasswordInput().click();
	}

	public void clickSignin() {
		getSignin().click();
	}

	public void clickRegister() {
		getRegister().click();
	}
	
	// Business Logic

	public LoginPage changeLanguage(ChangeLanguageFields language) {
		setChangeLanguage(language);
		// Return a new page object representing the destination.
		return new LoginPage(driver); // Do not use: return this; will be ERROR
	}

	// TODO Develop User class
	private void setLoginData(IUser user) {
		// private void setLoginData(String login, String password) {
		// logger.debug("Start");
		setLoginInputClear(user.getLogin());
		// logger.trace("setLoginInputClear() Done, User Login = " +
		// user.getLogin());
		setPasswordInputClear(user.getPassword());
		// logger.trace("setPasswordInputClear() Done, User Password = " +
		// user.getPassword());
		// setLoginInputClear(login);
		// setPasswordInputClear(password);
		clickSignin();
		// logger.trace("clickSignin() Done");
		// logger.debug("Done");
	}

	// public HomePage successUserLogin(IUser user) {
	// setLoginData(user);
	// // Return a new page object representing the destination.
	// return new HomePage(driver);
	// }

	public AdminHomePage successAdminLogin(IUser admin) {
		// public AdminHomePage successAdminLogin(String login, String password)
		// {
		setLoginData(admin);
		// setLoginData(login, password);
		// Return a new page object representing the destination.
		return new AdminHomePage(driver);
	}

	// public RegistratorHomePage successRegistratorLogin(IUser registrator) {
	// setLoginData(registrator);
	// // Return a new page object representing the destination.
	// return new RegistratorHomePage();
	// }
	//
	// TODO Develop User class
	// public LoginValidatorPage unsuccessfulLogin(IUser invalidUser) {
	// //public LoginValidatorPage unsuccessfulLogin(String login, String
	// password) {
	// setLoginData(invalidUser);
	// //setLoginData(login, password);
	// return new LoginValidatorPage(driver); // return this;
	// }

}
