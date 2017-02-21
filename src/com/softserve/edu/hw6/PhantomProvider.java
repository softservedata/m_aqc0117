package com.softserve.edu.hw6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class PhantomProvider implements DriverProvider {
	
	public WebDriver setDriver(){
		 System.setProperty("phantomjs.binary.path",
	                "c:/Program Files/Java/selenium-java-3.0.1/lib/phantomjs.exe");
	    WebDriver driver = new PhantomJSDriver();
		return driver;
		
	}

}
