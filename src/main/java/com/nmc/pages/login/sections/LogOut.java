package com.nmc.pages.login.sections;

import com.nmc.pages.login.UserLogOut;
import com.nmc.utilities.CommonActions;
/**
 * 
 * @author manish
 *
 */
public class LogOut 
{
	UserLogOut userLogOut;
	public LogOut(UserLogOut userLogOutObj) {
		userLogOut = userLogOutObj;
	}
	
	public void clickOnlogout()
	{
		CommonActions.clickElement(userLogOut.getLogout());
	}
	
}
