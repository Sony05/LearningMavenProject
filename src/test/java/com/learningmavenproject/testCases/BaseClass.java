package com.learningmavenproject.testCases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.learningmavenproject.utilities.ReadConfig;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	
	
	
	public String baseUrl = readconfig.getApplicationURL();
	public String userName = readconfig.getUserName();
	public String password = readconfig.getPassword();
	public static  WebDriver driver;
	
	public static Logger logger;

	@Parameters("browser")
	 @BeforeClass
	  public void setup(String br)
	  {

		logger = Logger.getLogger("LearningMavenProjectV1");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
		System.setProperty("Webdriver.chrome.driver", readconfig.getChromePath());
		driver = new ChromeDriver();
		}
		
		
		else if(br.equals("firefox"))
		{
			System.setProperty("Webdriver.firefox.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
				
		}
		
		else if(br.equals("Safari"))
		{
			driver = new SafariDriver();
				
		}
		driver.get(baseUrl);
}
		
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	

}
