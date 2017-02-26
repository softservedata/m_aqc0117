package com.softserve.edu.selen;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExampleWait {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.gecko.driver", "./lib/geckodriver.exe");
		// WebDriver driver = new FirefoxDriver();
		//
		System.setProperty("webdriver.chrome.driver",
				"./lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		//
		System.out.println("Page title is: " + driver.getTitle());
		//
		// BAD Code
		//Thread.sleep(500);
		//
		// driver.findElements(By.partialLinkText("Cheese"));
		//
		// Do not mix implicit and explicit waits.
		// Must be set 0 for use explicit waits.
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		//(new WebDriverWait(driver, 5)).until(ExpectedConditions.titleContains("heese"));
		// Restore implicet wait
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//
		//System.out.println("Page title is: " + driver.getTitle());
		//
		// Close the browser
		// Use Implicit Wait
		//WebElement myLink = driver.findElement(By.partialLinkText("heese"));
		//myLink.click();
		//
		// Best practice
		//driver.findElement(By.partialLinkText("heese")).click();
		//
		// Use Explicit Wait
		// Best
//		(new WebDriverWait(driver, 5))
//			.until(ExpectedConditions
//					.visibilityOfElementLocated(By.partialLinkText("heese"))).click();
		//
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		WebElement myLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("heese")));
//		myLink.click();
		//
		//List<WebElement> links = driver.findElements(By.partialLinkText("heese"));
		List<WebElement> links = (new WebDriverWait(driver, 5))
				.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.partialLinkText("heese")));
		System.out.println("count of links = " + links.size());
		//
		//((JavascriptExecutor) driver).executeScript("alert('Ha-Ha-Ha')");
		//Thread.sleep(2000);
		//driver.switchTo().alert().accept();
		//Thread.sleep(1000);
		//driver.quit();
	}

}
