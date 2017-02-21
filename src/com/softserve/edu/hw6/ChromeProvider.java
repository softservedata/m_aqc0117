package com.softserve.edu.hw6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeProvider implements DriverProvider {

	@Override
	public WebDriver setDriver() {
		System.setProperty("webdriver.chrome.driver",
				"c:/Program Files/Java/selenium-java-3.0.1/lib/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--no-proxy-server");
//		options.addArguments("--no-sandbox");
//		options.addArguments("--disable-web-security");
		options.addArguments("--ignore-certificate-errors");
//		options.addArguments("--disable-extensions");
		WebDriver driver = new ChromeDriver(options);
		//
		return driver;
	}

}
