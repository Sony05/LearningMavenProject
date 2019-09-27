package com.learningmavenproject.testCases;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.learningmavenproject.pageObjects.LoginPage;



public class TC_LogInTest_001 extends BaseClass
{
	@Test
	public void loginTest() throws IOException
	{
		
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		logger.info("Entered UserName");

		lp.setPassword(password);
		logger.info("Entered Password");
		lp.clickSubmit();

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage123"))
		{
		Assert.assertTrue(true);
		logger.info("Login Test Passed");

	}
		else {
		
		captureScreen(driver, "Login Test");
		Assert.assertTrue(false);
		logger.info("Login Test failed");
		

		
		}
		
	}
}
  