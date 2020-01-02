package com.nmc.pages.quicklinks.registration.opregistration.sections;

import com.nmc.infra.BaseClass;
import com.nmc.pages.quicklinks.registration.opregistration.OPRegistrationWebElements;
import com.nmc.utilities.CommonActions;
/**
 * 
 * @author manish
 *
 */
public class BasicInforamtion extends BaseClass
{
	OPRegistrationWebElements opRegObj;

	public BasicInforamtion(OPRegistrationWebElements opRegObject) {	
		opRegObj = opRegObject;
	}

	public void setSalutation(String salutation) {
		CommonActions.selectDropdownByOption(salutation,opRegObj.getSalutationDd());
		logger.info("salutation is set to "+salutation);
	}

	public void enterFirstName(String firstName) {
		CommonActions.enterData(firstName, opRegObj.getFirstName());
		logger.info("first Name is set to "+firstName);
	}

	public void enterMobNo(String mobNo) {
		CommonActions.enterData(mobNo, opRegObj.getMobNo());
		logger.info("Mobile Number is set to "+mobNo);
	}

	public void enterAge(String age) {
		CommonActions.enterData(age, opRegObj.getAge());
		logger.info("Age is set to "+age);
	}

	public void enterNxtKinName(String nextKinName) {
		CommonActions.enterData(nextKinName, opRegObj.getNxtKinName());
		logger.info("Next of Kin Name is set to "+nextKinName);
	}

}
