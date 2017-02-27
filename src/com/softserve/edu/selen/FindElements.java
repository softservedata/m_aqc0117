package com.softserve.edu.selen;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FindElements {

	//@Test
	public void checkMoveScroll() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//
		// Goto URL
		driver.get("http://www.seleniumhq.org/download/");
		//
		// Find By Implicit
		// partialLinkText
		//WebElement seleniumIDE = driver.findElement(By.partialLinkText("plugin tutorial page"));
		//
		// xpath
		//WebElement seleniumIDE = driver.findElement(By.xpath("//a[contains(@href,'/plugins.html')]"));
		//
		// name $x("//a[@name='side_plugins']")
//		List<WebElement> seleniumIDEs = driver.findElements(By.name("side_plugins"));
//		WebElement seleniumIDE = null;
//		for (WebElement current : seleniumIDEs) {
//			if (current.getText().toLowerCase().contains("selenium ide can")) {
//				seleniumIDE = current;
//				break;
//			}
//		}
//		if (seleniumIDE != null) {
//			System.out.println("Found OK");
//		}
		//
//		((JavascriptExecutor)driver).executeScript("alert('Ha-Ha-Ha')");
//		Thread.sleep(2000);
//		driver.switchTo().alert().accept();
		//
		// Find By JavaScript
//		WebElement seleniumIDE = (WebElement)
//                ((JavascriptExecutor)driver)
//                	.executeScript("return $(\"a[name='side_plugins']\")[1]");
		//
		// Explicit
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
   	    WebDriverWait wait = new WebDriverWait(driver, 10);
   	    WebElement seleniumIDE = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("side_plugins")));
		//
		System.out.println("seleniumIDE.getText() = " + seleniumIDE.getText());
		//
	}
	
	@Test
	public void checkLoginForm() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"./lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//
		driver.get("http://regres.herokuapp.com/login");
		Thread.sleep(2000);
		//
		WebElement changeLanguage = driver.findElement(By.id("changeLanguage"));
		List<WebElement> options = changeLanguage.findElements(By.tagName("option"));
	    for (WebElement current : options) {
			System.out.println(
					String.format("Value is: %s  Text is: %s", 
							current.getAttribute("value"),
							current.getText()));
			//current.click(); // ERROR, after refresh options is unavailable
			//Thread.sleep(2000);
	    }
	}

}
