package com.learningmavenproject.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.learningmavenproject.pageObjects.LoginPage;
import com.learningmavenproject.utilities.XLUtils;

public class TC_LoginDDT2_002 extends BaseClass{
	
	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd)
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("username provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickSubmit();
		if(isAlertPresent()== true)
		{
			driver.switchTo().alert().accept(); //close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		}
		else {
			Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.clickLogout();
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
		}
	}
	
	
	//user defined method to check alert is present or not
	public boolean isAlertPresent() 
	{
		try{
			driver.switchTo().alert();
		    return true;
		}
		catch(NoAlertPresentException e)
			{
			return false;
			}
		
		
	}
	 
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException  
	{
	String path = "/Users/sonysharma/eclipse-workspace/LearningMavenProjectV1/src/test/java/com/learningmavenproject/testData/LoginData.xlsx";	
	int rownum = XLUtils.getRowCount(path, "Sheet1");
	int cocount = XLUtils.getCellCount(path, "Sheet1", 1);
	
	String logindata[][]= new String[rownum][cocount];
	
	for(int i=1; i<= rownum; i++)
	{
		for(int j=0; j<cocount; j++)
		{
			logindata[i-1][j]= XLUtils.getCellData(path, "Sheet1", i, j);
		}
	}
	return logindata;
	
	}
	
	

}
