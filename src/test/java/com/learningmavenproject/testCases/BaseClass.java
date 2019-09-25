package com.learningmavenproject.testCases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class BaseClass {
	
	public String baseUrl = "http://demo.guru99.com/v4/index.php";
	public String userName = "mngr225088";
	public String password = "mAsavEr";
	public static  WebDriver driver;

	 @BeforeClass
	  public void setup()
	  {

		
		System.setProperty("Webdriver.chrome.driver", "Users/sonysharma/eclipse-workspace/LearningMavenProjectV1/Drivers/chromedriver");
		driver = new ChromeDriver();
		
		 }
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	

}
