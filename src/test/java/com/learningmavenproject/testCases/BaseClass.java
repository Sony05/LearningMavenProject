package com.learningmavenproject.testCases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class BaseClass {
	
	public String baseUrl = "http://demo.guru99.com/v4/index.php";
	public String userName = "mngr225088";
	public String password = "mAsavEr";
	public static  WebDriver driver;
	
	public static Logger logger;

	 @BeforeClass
	  public void setup()
	  {

		
		System.setProperty("Webdriver.chrome.driver", "Users/sonysharma/eclipse-workspace/LearningMavenProjectV1/Drivers/chromedriver");
		driver = new ChromeDriver();
		
		logger = Logger.getLogger("LearningMavenProjectV1");
		PropertyConfigurator.configure("Log4j.properties");
		 }
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	

}
