package com.nmc.pages.homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuickLinks {

	public QuickLinks(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=\"Search\"]")
	public WebElement searchdd;

	@FindBy(xpath = "//span[text()=\"Registration\"]")
	public WebElement registrationdd;
	
	@FindBy(xpath = "//span[text()='Billing']")
	public WebElement billingDd;
	
	@FindBy(xpath = "//span[text()='Billing']")
	public WebElement patientDd;
}
