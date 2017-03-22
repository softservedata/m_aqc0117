package com.softserve.edu.regres.tests;

import java.util.HashMap;

import org.testng.ITestContext;
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
	public void beforeClass(ITestContext context) {
		System.out.println("@BeforeClass");
		//
		// Get All Parameters
		// context.getCurrentXmlTest().getAllParameters()
		// Get Suite Parameters
		//context.getCurrentXmlTest().getSuite().getParameters()
		// Get Test Parameters
		//context.getCurrentXmlTest().getTestParameters()
        HashMap<String, String> testParameters = new HashMap<String, String>(context.getCurrentXmlTest().getAllParameters());
        //for (String key : testParameters.keySet()) {
        //	System.out.println("Test parameter: key=" + key + " value=" + testParameters.get(key));
        //}
        //
		//application = new Application(ApplicationSourcesRepository.getChromeOptionsHeroku());
		Application.get(ApplicationSourcesRepository.getChromeOptionsHeroku().update(testParameters));
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
