package com.softserve.edu.regres.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.softserve.edu.regres.apps.ApplicationSourcesRepository;
import com.softserve.edu.regres.pages.Application;

public class TestRunner {
	// Use if Application class not Singleton.
	//protected Application application;
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("@BeforeClass");
		//application = new Application(ApplicationSourcesRepository.getChromeOptionsHeroku());
		Application.get(ApplicationSourcesRepository.getChromeOptionsHeroku());
	}

	@AfterClass
	public void afterClass() {
		System.out.println("@AfterClass");
		Application.remove();
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("@BeforeMethod");
		//Application.get().load();
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("@AfterMethod");
		Application.get().logout();
	}

	
}
