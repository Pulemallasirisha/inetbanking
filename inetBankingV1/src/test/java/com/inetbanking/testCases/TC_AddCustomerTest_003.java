package com.inetbanking.testCases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException 
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("usrname is provided");
		lp.setPassword(password);
		logger.info("password is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.ClickAddNewCustomer();
		logger.info("providing customer details.");
		addcust.custName("Sirisha");
		addcust.custGender("Female");
		addcust.custDob("12","06","1998");
		Thread.sleep(3000);
		addcust.custAddress("India");
		addcust.custCity("Hyderabad");
		addcust.custState("Telangana");
		addcust.custpinno("500079");
		addcust.custtelephoneno("9550829610");
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("Siri@1208");
		addcust.custSubmit();
		
		Thread.sleep(3000);
		logger.info("validation started");
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case is passed");
		}
		else
		{
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
			logger.info("testcase is failed");
		}
	}
	
	
	
	
	
	
	
}
