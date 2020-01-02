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
public class SimpleOPInsRegistration
{	
	OPRegistrationWebElements opReg;
	
	PatientDetails patientDetails;
	BasicInforamtion basicInformation;
	EmployeeDetails edSection;
	
	//Excel File related 
	ConfigReader configReader;
	String xlFileName;
	String sheetName;
	
//	FileInputStream file ;
//	XSSFWorkbook workbook;
//	XSSFSheet sheet;
//	int rowCount;
//	int colCount;
	
	/**
	 * 
	 * @param driver
	 */
	
	public SimpleOPInsRegistration(WebDriver driver) {
		opReg = new OPRegistrationWebElements(driver);
		
		patientDetails = new PatientDetails(opReg);
		basicInformation= new BasicInforamtion(opReg);
		edSection = new EmployeeDetails();
		
		//Excel file Reader
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
//	public void enterBasicInformation() {
//		try {
//			basicInformation.setSalutation(XLUtils.getCellData(xlFileName, sheetName, 2, 7));
//			
//			basicInformation.enterFirstName(XLUtils.getCellData(xlFileName, sheetName, 2, 9));
//			basicInformation.enterMobNo(XLUtils.getCellData(xlFileName, sheetName, 2, 11));
//			basicInformation.enterAge(XLUtils.getCellData(xlFileName, sheetName, 2, 12));		
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}	
//	}
	public void enterBasicInformation(String ...obj ) throws IOException {
		basicInformation.setSalutation(obj[0].toString());
		basicInformation.enterFirstName(obj[1].toString());
		basicInformation.enterMobNo(obj[2].toString());
		basicInformation.enterAge(obj[3].toString());
		
	}
	
	/**
	 * Here parameter data will be read from XL file from resource folder
	 */
	public void enterPatientDetails()
	{
		patientDetails.setMrNumber();
		patientDetails.enterMrNum("121323123131");
	}
	
//	public Object[][] getExcelData() throws IOException
//	{
////		String path = System.getProperty("user.dir") + "/src/test/java/com/inetbanking/testData/loginData.xlsx";
//
//		int rowNum = XLUtils.getRowCount(xlFileName, sheetName);
//		int colNum = XLUtils.getCellCount(xlFileName, sheetName, 1);
//		System.out.println("Number of Roows are "+ rowNum);
//		System.out.println("number of columns are : "+colNum);
//		Object testObj[][] = new Object[rowNum][1];
//		String loginData[] = new String[colNum];
//
//		for (int i = 1; i <= rowNum; i++) {
//			for (int j = 0; j < colNum; j++) {
//				loginData[j] = XLUtils.getCellData(xlFileName, sheetName, i, j);	
//			}
//			testObj[i-1][0] = loginData;
//		}
//		return testObj;
//	}
	
	
	public String[][] getExcelData() throws IOException
	{
//		String path = System.getProperty("user.dir") + "/src/test/java/com/inetbanking/testData/loginData.xlsx";

		int rowNum = XLUtils.getRowCount(xlFileName, sheetName);
		int colNum = XLUtils.getCellCount(xlFileName, sheetName, 1);
		System.out.println("Number of Roows are "+ rowNum);
		System.out.println("number of columns are : "+colNum);
		String testObj[][] = new String[rowNum][colNum];
//		String loginData[] = new String[colNum];

		for (int i = 1; i <= rowNum; i++) {
			for (int j = 0; j < colNum; j++) {
				testObj[i-1][j] = XLUtils.getCellData(xlFileName, sheetName, i, j);	
			}
//			testObj[i-1][0] = loginData;
		}
		return testObj;
	}
	
}
