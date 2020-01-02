package com.nmc.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.nmc.infra.BaseClass;

public class CommonActions extends BaseClass {

	// click on element.
	public static void clickElement(WebElement element) {
		element.click();
	}

	// Enter data in the field.
	/**
	 * 
	 * @param data
	 * @param element
	 */
	public static void enterData(String data, WebElement element) {
		element.sendKeys(data);
	}

	/**
	 * 
	 * 
	 * @param index
	 * @param element
	 */
	public static void selectDropdownByIndex(int index, WebElement element) {
		Select dd = new Select(element);
		dd.selectByIndex(index);
	}

	/**
	 * This method sets the given input value to a dropdown
	 * 
	 * @param option takes the given input value
	 * @param element takes the corresponding webelement object
	 */
	public static void selectDropdownByOption(String option, WebElement element) {
		Select dd = new Select(element);
		dd.selectByVisibleText(option);
	}

	public static String getText(WebElement element) {
		return element.getText();
	}

	public static void goToTheUrl(String url) {
		driver.navigate().to(url);
	}

	public static void clearField(WebElement element) {
		element.clear();
	}

	public static String getAttributeValue(String value, WebElement element) {
		// String value="";// this is used to get the value from text field
		return element.getAttribute(value);
	}

	// Returns page title
	public static String getPageTitle() {
		return driver.getTitle();
	}

}
