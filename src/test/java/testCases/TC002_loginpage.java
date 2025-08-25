package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Myaccountpage;
import pageObjects.loginpage;
import testBase.Baseclass;

public class TC002_loginpage extends Baseclass{

	@Test(groups = "Regression")
	public void verifylogin() 
	{
		logger.info("Started test");
		try {
		logger.info("Test started");
		Homepage home = new Homepage(driver);
		home.clickaccount();
		home.clicklogin();
		
		loginpage log = new loginpage(driver);
		log.enteremai(p.getProperty("email"));
		log.enterpassword(p.getProperty("password"));
		log.clicklogin();
		
		Myaccountpage myaccount = new Myaccountpage(driver);
		boolean target = myaccount.accountpageopen();
		Assert.assertTrue(target);
		}
		catch (Exception e) {
			Assert.fail();
		}
		logger.info("ended test");

	}
	
	
	
	
	
	
}
