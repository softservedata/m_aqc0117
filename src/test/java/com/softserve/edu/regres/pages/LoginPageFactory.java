package com.softserve.edu.regres.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.softserve.edu.regres.data.IUser;

public class LoginPageFactory {
	//
	//private static final String REGISTER_ERROR = "Button Register not Found";
	//
	// Expected text
	public static final String SRC_ATTRIBUTE = "src";
	public static final String NAME_IMAGE = "ukraine_logo2.gif";

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	// Fields

	private WebDriver driver;
	//
	@FindBy(css = "div.col-md-7.col-xs-12")
	private WebElement titleMessage;
	//
	@FindBy(xpath = "//label[contains(@for,'inputEmail')]")
	private WebElement loginLabel;
	//
	//@CacheLookup
	@FindBy(id = "login")
	private WebElement loginInput;
	//
	@FindBy(xpath = "//label[contains(@for,'inputPassword')]")
	private WebElement passwordLabel;
	//
	@FindBy(id = "password")
	private WebElement passwordInput;
	//
	@FindBy(css = "button.btn.btn-primary")
	private WebElement signin;
	//
	@FindBy(css = "img.login_logo.col-md-8.col-xs-12")
	private WebElement logo;

	public LoginPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // 1st item
	}

	// PageObject

	// get Data

	public WebElement getLoginLabel() {
		return this.loginLabel;
	}

	public WebElement getLoginInput() {
		return this.loginInput;
	}

	public WebElement getPasswordLabel() {
		return this.passwordLabel;
	}

	public WebElement getPasswordInput() {
		return this.passwordInput;
	}

	public WebElement getSignin() {
		return this.signin;
	}

	public WebElement getLogo() {
		return this.logo;
	}

//	public boolean isRegisterExist() {
//		register = driver.findElements(By.cssSelector(REGISTER_BUTTON_CSSSELECTOR));
//		return register.size() > 0;
//	}

//	public WebElement getRegister() {
//		if (!isRegisterExist()) {
//			throw new GeneralRegresException(REGISTER_ERROR);
//		}
//		return register.get(0);
//	}

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

//	public String getRegisterText() {
//		return getRegister().getText().trim();
//	}

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

//	public void clickRegister() {
//		getRegister().click();
//	}
	
	// Business Logic

//	public LoginPage changeLanguage(ChangeLanguageFields language) {
//		setChangeLanguage(language);
//		// Return a new page object representing the destination.
//		return new LoginPage(driver); // Do not use: return this; will be ERROR
//	}

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