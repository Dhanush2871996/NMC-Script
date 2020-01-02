package com.nmc.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * All the Web Element of the Login page
 * @author manish
 *
 */
public class UserLogin
{
	// PageFactory for initializing webElements
	public UserLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Web elements in the login page
	 */
	@FindBy(id = "userId")
	public WebElement userName;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(id = "button")
	public WebElement submitButton;
	
	@FindBy(xpath = "/html/body/table/tbody/tr[1]/td[3]/span[2]/a/img")
	public WebElement logOutBtn;

}
