package com.learningmavenproject.testCases;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.learningmavenproject.utilities.ReadConfig;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	  }
		
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("/Users/sonysharma/eclipse-workspace/LearningMavenProjectV1")+"/Screenshots" +tname +".png");
		FileUtils.copyFile(srcFile, destFile);
		System.out.println("Screenshot taken");
	}
}	



	


