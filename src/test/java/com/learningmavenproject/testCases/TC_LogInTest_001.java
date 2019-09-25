package com.learningmavenproject.testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.learningmavenproject.pageObjects.LoginPage;



public class TC_LogInTest_001 extends BaseClass
{
	@Test
	public void loginTest()
	{
		
		driver.get(baseUrl);
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		logger.info("Entered UserName");

		lp.setPassword(password);
		logger.info("Entered Password");
		lp.clickSubmit();

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
		Assert.assertTrue(true);
		logger.info("Login Test Passed");

	}
		else {
		Assert.assertTrue(false);
		logger.info("Login Test failed");

		
		}
		
	}
}
  