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
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);

		lp.setPassword(password);
	
		lp.clickSubmit();

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
		Assert.assertTrue(true);

	}
		else {
		Assert.assertTrue(false);

		
		}
		
	}
}
  