package com.nmc.pages.login.sections;

import com.nmc.pages.login.UserLogin;
import com.nmc.utilities.CommonActions;
/**
 * 
 * @author manish
 *
 */

public class Login {

	UserLogin userLoginObj;

	public Login(UserLogin userLoginObject) {		
		userLoginObj = userLoginObject;
	}
	
	public void setUserName(String userName)
	{
		CommonActions.enterData(userName, userLoginObj.userName);
	}
	
	public void setPassword(String password)
	{
		CommonActions.enterData(password, userLoginObj.password);
	}
	
	public void clickSubmitBtn()
	{
		CommonActions.clickElement(userLoginObj.submitButton);
	}
	
	public void clickOnLogOutBtn()
	{
		CommonActions.clickElement(userLoginObj.logOutBtn);
	}
}
