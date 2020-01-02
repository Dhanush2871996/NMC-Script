package com.nmc.testcases.testcase01;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nmc.infra.BaseClass;
import com.nmc.pages.login.UserLogOut;
import com.nmc.pages.login.scenarios.LoginToApplication;
import com.nmc.pages.quicklinks.registration.opregistration.OPRegistrationWebElements;
import com.nmc.pages.quicklinks.registration.opregistration.scenarios.SimpleOPInsRegistration;

/**
 * 
 * @author manish
 *
 */

public class SampleTestCase extends BaseClass {

	SimpleOPInsRegistration simpleOpInsReg;
	OPRegistrationWebElements opRegWeb;
	LoginToApplication loginToApp;
	UserLogOut logout;

	@BeforeClass
	public void before_method() {
		simpleOpInsReg = new SimpleOPInsRegistration(driver);
		loginToApp = new LoginToApplication(driver);
		logout = new UserLogOut(driver);
	}

	/**
	 * 
	 * @throws IOException 
	 * 
	 */
	@Test(dataProvider="regData" )
	public void test_1(String ... data) throws IOException
	{
		loginToApp.login();
		simpleOpInsReg.getOpRegObject().navigateToOpRegScr();
		simpleOpInsReg.enterBasicInformation(data);
		loginToApp.logOut();
		
	}

	@AfterMethod
	public void after_method() {

	}
	@DataProvider(name="regData")
	Object[][] getData() throws IOException
	{
		return simpleOpInsReg.getExcelData();
		
	}

}
