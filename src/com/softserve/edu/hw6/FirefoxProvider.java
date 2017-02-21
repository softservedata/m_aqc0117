package com.softserve.edu.hw6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public  class FirefoxProvider implements DriverProvider {
	

	
	@Override
	public  WebDriver setDriver() {
		System.setProperty("webdriver.gecko.driver", "c:/Program Files/Java/selenium-java-3.0.1/lib/geckodriver.exe");
		WebDriver driver =  new FirefoxDriver();
		return driver;
	}

}
