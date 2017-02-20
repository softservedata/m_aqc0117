package com.softserve.edu.selen;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Browsers {
	public static ChromeDriverService service;

	//@Test
	public void testFirefox1() throws Exception {
		WebDriver driver = new FirefoxDriver();
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		Thread.sleep(2000);
		driver.quit();
	}

	//@Test
	public void testFirefox1_301() throws Exception {
		System.setProperty("webdriver.gecko.driver", "./lib/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		Thread.sleep(2000);
		//driver.quit();
	}

	//@Test
    public void testFirefox2() throws Exception {
        ProfilesIni profileIni = new ProfilesIni();
        FirefoxProfile profile = profileIni.getProfile("default");
        //
        profile.setAcceptUntrustedCertificates(true);
        profile.setPreference("app.update.enabled", false);
        //
		System.setProperty("webdriver.gecko.driver", "./lib/geckodriver.exe");
        WebDriver driver = new FirefoxDriver(profile);
        //
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Cheese!");
        element.submit();
        // driver.quit();
    }

	//@Test
	public void testFirefox3() throws Exception {
		System.setProperty("webdriver.gecko.driver", "./lib/geckodriver.exe");
		//
		FirefoxProfile profile = new FirefoxProfile();
		File file = new File("lib/firebug-2.0.18-fx.xpi");
		profile.addExtension(file);
		//
		profile.setAcceptUntrustedCertificates(true);
		profile.setPreference("extensions.firebug.currentVersion","2.0.18");
		//
		WebDriver driver = new FirefoxDriver(profile);
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		// driver.quit();
	}

	//@Test
	public void testFirefox4() throws Exception {}

	//@Test
	public void testInternetExplorer1() throws Exception {
		System.setProperty("webdriver.ie.driver",
				"./lib/IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		// driver.quit();
	}

	//@Test
	public void testInternetExplorer2() throws Exception {
		System.setProperty("webdriver.ie.driver",
				"./lib/IEDriverServer.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		WebDriver driver = new InternetExplorerDriver(capabilities);
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		// driver.quit();
	}

	//@Test
	public void testChrome1() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"./lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		// driver.quit();
	}
	
	//@Test
	public void testChrome2() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"./lib/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--no-proxy-server");
//		options.addArguments("--no-sandbox");
//		options.addArguments("--disable-web-security");
		options.addArguments("--ignore-certificate-errors");
//		options.addArguments("--disable-extensions");
		WebDriver driver = new ChromeDriver(options);
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		//
		driver.get("https://ita.edu.softserveinc.com/");
		// driver.quit();
	}

	//@Test
	public void testChrome3UserProfile() throws Exception {
	    System.out.println("HOME_PATH getenv = " + System.getenv("HOMEPATH"));
	    //System.out.println("HOME_PATH Property = " + System.getProperty("HOMEPATH"));
		System.setProperty("webdriver.chrome.driver",
				"./lib/chromedriver.exe");
		//String userProfile = "C:\\Users\\yharasym\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
		String userProfile = System.getenv("HOMEPATH") + "\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--no-proxy-server");
//		options.addArguments("--no-sandbox");
//		options.addArguments("--disable-web-security");
		options.addArguments("--ignore-certificate-errors");
//		options.addArguments("--disable-extensions");
		options.addArguments("--user-data-dir=" + userProfile);
		WebDriver driver = new ChromeDriver(options);
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		// driver.quit();
	}

	//@Test
	public void testChrome4() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"./lib/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--no-proxy-server");
//		options.addArguments("--no-sandbox");
//		options.addArguments("--disable-web-security");
		options.addArguments("--ignore-certificate-errors");
//		options.addArguments("--disable-extensions");
		//WebDriver driver = new ChromeDriver(options);
		//
		options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		//options.setBinary("C:\\Windows\\system32\\calc.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver driver = new ChromeDriver(capabilities);
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		// driver.quit();
	}
	
	// Use Selenium 2.52
	//@Test
	public void testHtmlUnit() throws Exception {
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new HtmlUnitDriver(true);
        ((HtmlUnitDriver) driver).setJavascriptEnabled(true);
        //
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		System.out.println("\tdriver.get http://www.google.com DONE");
		System.out.println("\tCurrent title is: " + driver.getTitle());
		Thread.sleep(1000);
		//
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		System.out.println("\telement.sendKeys Cheese! DONE");
		System.out.println("\tPage title is: " + driver.getTitle());
		element.submit();
		Thread.sleep(1000);
		//WebDriverWait wait = new WebDriverWait(driver, 5);
		//wait.until(ExpectedConditions.titleContains("Cheese"));
//		(new WebDriverWait(driver, 5)).until(
//                ExpectedConditions.titleContains("Cheese"));
		System.out.println("\tPage title is: " + driver.getTitle());
		//
		driver.findElement(By.partialLinkText("Cheese - Wikipedia")).click();
		System.out.println("\tELEMENT IS " + driver.findElement(By.id("firstHeading")).getText());
		Assert.assertEquals(driver.findElement(By.id("firstHeading")).getText(), "Cheese");
		//Thread.sleep(2000);
		//driver.quit();
		driver.quit();
	}

	//@Test
	public void testpPhantomjs() throws Exception {
        System.setProperty("phantomjs.binary.path",
                "./lib/phantomjs.exe");
        WebDriver driver = new PhantomJSDriver();
		//
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		System.out.println("\tdriver.get http://www.google.com DONE");
		System.out.println("\tCurrent title is: " + driver.getTitle());
		Thread.sleep(1000);
		//
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		System.out.println("\telement.sendKeys Cheese! DONE");
		System.out.println("\tPage title is: " + driver.getTitle());
		element.submit();
		Thread.sleep(1000);
		//WebDriverWait wait = new WebDriverWait(driver, 5);
		//wait.until(ExpectedConditions.titleContains("Cheese"));
//		(new WebDriverWait(driver, 5)).until(
//                ExpectedConditions.titleContains("Cheese"));
		System.out.println("\tPage title is: " + driver.getTitle());
		//
		driver.findElement(By.partialLinkText("Cheese - Wikipedia")).click();
		System.out.println("\tELEMENT IS " + driver.findElement(By.id("firstHeading")).getText());
		Assert.assertEquals(driver.findElement(By.id("firstHeading")).getText(), "Cheese");
		//
		System.out.println("\tTaking Screenshot ...");
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./screenshot1.png"));
		System.out.println("\tDone Screenshot");
        //
		//Thread.sleep(2000);
		//driver.quit();
		driver.quit();
	}

	
	@BeforeClass
	public static void createService() throws Exception {
		service = new ChromeDriverService.Builder()
				.usingDriverExecutable(
						new File("./lib/chromedriver.exe"))
				// .usingAnyFreePort()
				.usingPort(8888).build();
		service.start();
		System.out.println("\t+++Service Start");
	}

	@Test
	public void testRemout() throws Exception {
		//
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--no-proxy-server");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-web-security");
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--disable-extensions");
		//WebDriver driver = new ChromeDriver(options);
		//
		options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		//
		//WebDriver driver = new RemoteWebDriver(new URL("127.0.0.1:8888"), capabilities);
		WebDriver driver = new RemoteWebDriver(service.getUrl(), capabilities);
		System.out.println("\t+++RemoteWebDriver Start, service.getUrl()=" + service.getUrl());
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		Thread.sleep(4000);
		driver.quit();
	}
	
	@AfterClass
	public static void StopService() {
		if (service != null) {
			service.stop();
			System.out.println("\t+++RemoteWebDriver Stop");
		}
	}

}
