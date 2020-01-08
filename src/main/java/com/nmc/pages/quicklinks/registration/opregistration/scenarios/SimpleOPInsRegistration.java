package com.nmc.pages.quicklinks.registration.opregistration.scenarios;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.nmc.pages.quicklinks.registration.opregistration.OPRegistrationWebElements;
import com.nmc.pages.quicklinks.registration.opregistration.sections.BasicInforamtion;
import com.nmc.pages.quicklinks.registration.opregistration.sections.EmployeeDetails;
import com.nmc.pages.quicklinks.registration.opregistration.sections.PatientDetails;
import com.nmc.utilities.ConfigReader;
import com.nmc.utilities.XLUtils;

/**
 *
 * 
 * @author manish
 *
 */
public class SimpleOPInsRegistration {
	OPRegistrationWebElements opReg;

	PatientDetails patientDetails;
	BasicInforamtion basicInformation;
	EmployeeDetails edSection;

	// Excel File related
	ConfigReader configReader;
	String xlFileName;
	String sheetName;

	/**
	 * 
	 * @param driver
	 */

	public SimpleOPInsRegistration(WebDriver driver) {
		opReg = new OPRegistrationWebElements(driver);

		patientDetails = new PatientDetails(opReg);
		basicInformation = new BasicInforamtion(opReg);
		edSection = new EmployeeDetails();

		// Excel file Reader
		configReader = new ConfigReader();
		xlFileName = configReader.getExcelRegistrationDataPath();
		sheetName = configReader.getExcelRegistrationDataSheetName();

	}

	/**
	 * 
	 * @return returning PORegistrationWebelemntObject
	 */
	public OPRegistrationWebElements getOpRegObject() {
		return opReg;
	}

	/**
	 * Here parameter data will be read from XL file from resource folder
	 */
	public void enterBasicInformation(String... obj) throws IOException {
		basicInformation.setSalutation(obj[0].toString());
		basicInformation.enterFirstName(obj[1].toString());
		basicInformation.enterMobNo(obj[2].toString());
		basicInformation.enterAge(obj[3].toString());

	}

	/**
	 * Here parameter data will be read from XL file from resource folder
	 */
	public void enterPatientDetails() {
		patientDetails.setMrNumber();
		patientDetails.enterMrNum("121323123131");
	}

	public String[][] getExcelData() throws IOException {

		int rowNum = XLUtils.getRowCount(xlFileName, sheetName);
		int colNum = XLUtils.getCellCount(xlFileName, sheetName, 1);
		System.out.println("Number of Roows are " + rowNum);
		System.out.println("number of columns are : " + colNum);
		String testObj[][] = new String[rowNum][colNum];

		for (int i = 1; i <= rowNum; i++) {
			for (int j = 0; j < colNum; j++) {
				testObj[i - 1][j] = XLUtils.getCellData(xlFileName, sheetName, i, j);
			}
		}
		return testObj;
	}

}
