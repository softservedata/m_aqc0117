package com.softserve.edu.regres.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.softserve.edu.regres.apps.ApplicationSources;
import com.softserve.edu.regres.apps.ApplicationSourcesRepository;

public class Application {

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	private interface IBrowser {
		WebDriver getBrowser(Application application);
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	private static class Firefox4701Temporary implements IBrowser {
		public WebDriver getBrowser(Application application) {
			return new FirefoxDriver();
		}
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	private static class Firefox50xxTemporary implements IBrowser {
		public WebDriver getBrowser(Application application) {
			System.setProperty("webdriver.gecko.driver",
					application.applicationSources.getDriverPath());
			//System.out.println("+++ FirefoxTemporary "
			//		+ application.applicationSources.getDriverPath());
			return new FirefoxDriver();
		}
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	private static class ChromeTemporary implements IBrowser {
		public WebDriver getBrowser(Application application) {
			System.setProperty("webdriver.chrome.driver",
					application.applicationSources.getDriverPath());
			return new ChromeDriver();
		}
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	private static class ChromeOptionsTemporary implements IBrowser {
		public WebDriver getBrowser(Application application) {
			System.setProperty("webdriver.chrome.driver",
					application.applicationSources.getDriverPath());
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-proxy-server");
			return new ChromeDriver(options);
		}
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	private static class HtmlUnitTemporary implements IBrowser {
		public WebDriver getBrowser(Application application) {
			//WebDriver driver = null;
			WebDriver driver = new HtmlUnitDriver(true);
			((HtmlUnitDriver) driver).setJavascriptEnabled(true);
			return driver;
		}
	}
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	public static enum Browsers {
		DEFAULT_TEMPORARY("ChromeTemporary", new ChromeTemporary()),
		FIREFOX4701_TEMPORARY("FireFox4701.Temporary", new Firefox4701Temporary()),
		FIREFOX50XX_TEMPORARY("FireFox50xx.Temporary", new Firefox50xxTemporary()),
		CHROME_TEMPORARY("ChromeTemporary", new ChromeTemporary()),
		CHROME_OPTIONS_TEMPORARY("ChromeOptionsTemporary", new ChromeOptionsTemporary()),
		HTMLUNIT_TEMPORARY("HtmlUnitTemporary", new HtmlUnitTemporary());
		//
		private String browserName;
		private IBrowser browser;

		private Browsers(String browserName, IBrowser browser) {
			this.browserName = browserName;
			this.browser = browser;
		}

		public WebDriver runBrowser(Application application) {
			return browser.getBrowser(application);
		}

		@Override
		public String toString() {
			return browserName;
		}
	}
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	// Use Singleton, Repository
	private static volatile Application instance;
	//
	// Fields
	//
	private WebDriver driver;
	private ApplicationSources applicationSources;
	// etc.
	
	private Application(ApplicationSources applicationSources) {
		this.applicationSources = applicationSources;
	}

	public static Application get() {
		return get(null);
	}

	public static Application get(ApplicationSources applicationSources) {
		if (instance == null) {
			synchronized (Application.class) {
				if (instance == null) {
					if (applicationSources == null) {
						applicationSources = ApplicationSourcesRepository.getDefault();
					}
					instance = new Application(applicationSources);
					instance.init();
				}
			}
		}
		return instance;
	}

	// TODO Close All Threads
	public static void remove() {
		if (instance != null) {
			instance.quit();
		}
		instance = null;
	}

	public void init() {
		initWebDriver();
		// TODO
		// Init Strategy from applicationSources
		// Init DB access, etc.
	}

	public LoginPage load() {
		//logout();
		getWebDriver().get(applicationSources.getLoginUrl());
		return new LoginPage(driver);
	}

	public LoginPage login() {
		logout();
		getWebDriver().get(applicationSources.getLoginUrl());
		return new LoginPage(driver);
	}

	public LoginPage logout() {
		getWebDriver().get(applicationSources.getLogoutUrl());
		return new LoginPage(driver);
	}

	public void quit() {
		if (getWebDriver() != null) {
			getWebDriver().quit();
		}
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	private void initWebDriver() {
		Browsers currentBrowser = Browsers.DEFAULT_TEMPORARY;
		for (Browsers browser : Browsers.values()) {
			//System.out.println("***initWebDriver()  browser.toString().toLowerCase() "+browser.toString().toLowerCase());
			//System.out.println("***initWebDriver() applicationSources.getBrowserName().toLowerCase() "+applicationSources.getBrowserName().toLowerCase());
			//System.out.println("*** "+browser.toString().toLowerCase()
			//		.contains(applicationSources.getBrowserName().toLowerCase()));
			if (browser.toString().toLowerCase()
					.contains(applicationSources.getBrowserName().toLowerCase())) {
				currentBrowser = browser;
				//System.out.println("***Update to "+applicationSources.getBrowserName().toLowerCase());
				break;
			}
		}
		driver = currentBrowser.runBrowser(this);
		//
		// TODO Move to Strategy class
		driver.manage().timeouts()
			.implicitlyWait(applicationSources.getImplicitTimeOut(), TimeUnit.SECONDS);
	}

}
