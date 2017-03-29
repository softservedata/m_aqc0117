package com.softserve.edu.regres.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.regres.data.IUser;
import com.softserve.edu.regres.data.UserRepository;
import com.softserve.edu.regres.pages.Application;
import com.softserve.edu.regres.pages.CommonPage;
import com.softserve.edu.regres.pages.LoginPage;
import com.softserve.edu.regres.tools.ListUtils;

public class CommonRunnerTest extends TestRunner {

	@DataProvider // (parallel = true) // Not parallel
	public Object[][] validUsers() {
		//return ListUtils.toMultiArray(UserRepository.get().getUsersFromCsvFile("/users.csv"));
		//return ListUtils.toMultiArray(UserRepository.get().getUsersFromExcelFile("/users.xlsx"));
		return ListUtils.toMultiArray(UserRepository.get().getUsersFromDB("select Firstname, Lastname, Email, Login, Password, Community from newusers;"));
	}

	@Test(dataProvider = "validUsers")
	public void checkLogin(IUser user) throws Exception {
		// Precondition.
		//
		// Test steps.
		// LoginPage loginPage = new LoginPage(driver);
		LoginPage loginPage = Application.get().login();
		// LoginPage loginPage = Application.get().load();
		Thread.sleep(1000);
		//
		CommonPage commonPage = loginPage.successUserLogin(user);
		Thread.sleep(1000);
		//
		// Check.
		//System.out.println("commonPage.getLoginAccount() = " + commonPage.getLoginAccountText());
		//System.out.println("user.getLogin() = " + user.getLogin());
		Assert.assertEquals(commonPage.getLoginAccountText(), 
				user.getLogin());
		Thread.sleep(1000);
		//
		// Return to previous state.
		commonPage.clickLogout();
		// Application.remove();
	}

}
