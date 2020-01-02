package com.nmc.pages.login.scenarios;

import org.openqa.selenium.WebDriver;

import com.nmc.pages.login.UserLogin;
import com.nmc.pages.login.sections.Login;
/**
 * 
 * @author manish
 *
 */

public class LoginToApplication {

	UserLogin userLoginObj;
	Login login;

	/**
	 * 
	 * @param driver
	 */
	public LoginToApplication(WebDriver driver) {
		userLoginObj = new UserLogin(driver);
		login = new Login(userLoginObj);
	}
	
	public UserLogin getUserLoginObj() {
		return userLoginObj;
	}
	
	/**
	 * Here we will be passing the parameters from XL files 
	 */
	public void login()
	{
		login.setUserName("manishDoc");
		login.setPassword("Nmc@1234");
		login.clickSubmitBtn();
	}
	
	public void logOut() {
		login.clickOnLogOutBtn();
	}
}
