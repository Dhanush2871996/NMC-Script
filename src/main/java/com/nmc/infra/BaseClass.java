package com.nmc.infra;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nmc.utilities.ConfigReader;

/*
 * setUP
 * Screen shot
 * close driver(tear down)
 */
public class BaseClass 
{
	ConfigReader readConfig = new ConfigReader();
	
	public String baseURL= readConfig.getApplicationURL();
	public String userID= readConfig.getUserName();
	public String password = readConfig.getPassword();
	
	public static WebDriver driver;
	public static Logger logger; 
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String browser)		//all the prerequsite include in this.( br = bowser)
	{
		//configuration we have to do for the base class
		logger = Logger.getLogger("Instanmc.Automation"); //name of the project
		PropertyConfigurator.configure("./configuration/log4j.properties");
		//Initialize Chrome browser
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readConfig.getChromePath());
			driver = new ChromeDriver(); //Instantiation(i.e create chrome driver object)
		}
		//Initialize FireFox browser
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readConfig.getFirefoxPath());
			driver = new FirefoxDriver(); //Instantiation(i.e create firefox driver object)
		}
		else if(browser.equalsIgnoreCase("phantomjs"))
		{
			System.setProperty("phantomjs.binary.path",readConfig.getPhantomjsPath());
			driver = new PhantomJSDriver(); //Instantiation(i.e create firefox driver object)
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", readConfig.getIEPath());
			driver = new InternetExplorerDriver();
		}
		
		driver.get(baseURL);
		logger.info("URL is opened where page title is : "+driver.getTitle());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

//	@AfterClass
//	public void tearDown()
//	{
//		driver.quit();
//	}

	public Logger getLogger() {
		return logger;
	}

}
