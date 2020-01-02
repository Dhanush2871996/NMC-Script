package com.nmc.pages.quicklinks.registration.opregistration.sections;

import com.nmc.pages.quicklinks.registration.opregistration.OPRegistrationWebElements;
import com.nmc.utilities.CommonActions;

public class PatientDetails
{
	OPRegistrationWebElements opRegObj;

	public PatientDetails(OPRegistrationWebElements opRegObject) {
		opRegObj = opRegObject;
	}

	public void setMrNumber()
	{
		CommonActions.clickElement(opRegObj.getMrNoRBtn());
	}
	
	public void enterMrNum(String mrNumber)
	{
		CommonActions.enterData(mrNumber, opRegObj.getMrNoTextfield());
	}
}
