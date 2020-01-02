package com.nmc.pages.quicklinks.registration.opregistration.sections;

import java.util.Map;

import org.openqa.selenium.WebElement;

import com.nmc.utilities.CommonActions;

public class EmployeeDetails {
	
	public void setEmployer(String empType,WebElement element) {
		CommonActions.selectDropdownByOption(empType, element);
	}
	
	public void setAllEmployerDetails(Map values,WebElement element) {
		
	}

}
