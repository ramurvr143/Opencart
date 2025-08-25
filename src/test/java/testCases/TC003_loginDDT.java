package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Myaccountpage;
import pageObjects.loginpage;
import testBase.Baseclass;
import utilities.Dataprovider;

@Test(dataProvider = "logindata",dataProviderClass = Dataprovider.class,groups = "Sanity")
public class TC003_loginDDT extends Baseclass 
{
	public void verifylogin(String email, String psw, String result) 
	{
		try {
	Homepage home = new Homepage(driver);
	home.clickaccount();
	home.clicklogin();
	
	loginpage log = new loginpage(driver);
	log.enteremai(email);
	log.enterpassword(psw);
	log.clicklogin();
	
	Myaccountpage myaccount = new Myaccountpage(driver);
	boolean target = myaccount.accountpageopen();
	
	if(result.equalsIgnoreCase("Valid"))
	{
		if(target == true)
		{
			myaccount.clicklogout();
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}

	if(result.equalsIgnoreCase("Invalid"))
	{
		if(target == true)
		{
			myaccount.clicklogout();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
		}
	}
		}
		catch (Exception e) 
		{
			Assert.fail();
		}
	}
	
}
