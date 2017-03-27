package com.softserve.edu.regres.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReportTest {

	@BeforeMethod
	public void setUp() throws Exception {
		System.out.println("CalcTest @Before setUp()");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		System.out.println("CalcTest @After tearDown()");
		Reporter.log("<BR><FONT SIZE='4' COLOR='RED'>@AfterMethod Non Conditional.</FONT><BR>", true);
		Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>@AfterMethod Level 3</FONT><BR>", 3, true);
		Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>@AfterMethod Level 5</FONT><BR>", 5);
		Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>@AfterMethod Level 7</FONT><BR>", 7, true);
	}

	@Test
	public void testApp() {
		// Use Testng.xml: 3 ERROR 5 WARNING 7 INFO 9 DEBUG
		Reporter.log("<BR><FONT SIZE='4' COLOR='RED'>@Test Non Conditional. Report Only </FONT><BR>");
		Reporter.log("<BR><FONT SIZE='4' COLOR='RED'>@Test Non Conditional.</FONT><BR>", true);
		Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>@Test Level 3</FONT><BR>", 3, true);
		Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>@Test Level 5</FONT><BR>", 5);
		Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>@Test Level 7</FONT><BR>", 7, true);
		System.out.println("Running . . .");
		Assert.assertTrue(true);
	}

}