package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Accountregistrationpage;
import pageObjects.Homepage;
import testBase.Baseclass;

public class TC001_regestration extends Baseclass
{
	@Test(groups = {"Sanity","Master"})
	
	
	public void verify_account() 
	{
	logger.info("***** Open Home Page *****");	
		Homepage hp = new Homepage(driver);
		hp.clickaccount();
		hp.clickregister();
		
	logger.info("***** Open Accountreg Page *****");	
		Accountregistrationpage regpage= new Accountregistrationpage(driver);
		regpage.setfirstname(randomstring().toUpperCase());
		regpage.setlastname(randomstring().toUpperCase());
		regpage.setemail(randomstring()+"@gmail.com");
		regpage.settelephone(randomnumeric());
		String pswd=mixedstring();
		regpage.setpassword(pswd);
		regpage.setconfirmpassword(pswd);
		regpage.setprivacy();
		regpage.clickcontinue();
		String confirmmessage =regpage.getmessage();
		AssertJUnit.assertEquals(confirmmessage, "Your Account Has Been Created!");
		logger.info(confirmmessage);
		logger.info("*** testcase 1 completed ***");

	}
	

}
