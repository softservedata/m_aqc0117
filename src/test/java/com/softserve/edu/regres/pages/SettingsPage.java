package com.softserve.edu.regres.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SettingsPage extends AdminHomePage {

	// Fields
	
	private WebElement personal;
	private WebElement manual;
	
	public SettingsPage(WebDriver driver) {
		super(driver);
		this.personal = driver.findElement(By.xpath("//input[@name='registrationMethod' and @value='PERSONAL']"));
		this.manual = driver.findElement(By.xpath("//input[@name='registrationMethod' and @value='MANUAL']"));
	}
	
	// PageObject

	// get Data

	public WebElement getPersonal() {
		return this.personal;
	}

	public WebElement getManual() {
		return this.manual;
	}

	// Functional

	public boolean getPersonalSelected() {
		return getPersonal().isSelected();
	}

	public boolean getManualSelected() {
		return getManual().isSelected();
	}

	// set Data

	public void clickPersonal() {
		getPersonal().click();
	}

	public void clickManual() {
		getManual().click();
	}

	// Business Logic

}
