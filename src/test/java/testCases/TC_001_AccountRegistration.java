package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegristration;
import pageObjects.Homepage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass
{

	@Test(groups= {"Regression","Master"}) //Step8 groups added
	public void test_accountregistration()
	{
		logger.debug("Application logs...");
		logger.info("*** String TC_001_AccountRegistration ***");
		
		//randomly data generate
		try
		{
		Homepage hp=new Homepage(driver);
		hp.myaccountclick();
		logger.info("Clicked on My account link");
		
		hp.registrationclick();
		logger.info("Clicked on registration link");
		
		
		
		 AccountRegristration Ac=new  AccountRegristration (driver);
		 
		 logger.info("providing customer data");
		 
		 Ac.setFirstname(randomeString().toUpperCase());
		 Ac.setLastname(randomeString().toUpperCase());
		 
		 Ac.SetEmailid(randomeString()+"@gmail.com");
		 Ac.setTelephone(randomeNumber());
		 
		 String password=randomAlphaNumeric();
		 Ac.setpassword(password);
		 Ac.setConfirmpassword(password);
		 
		 
		 Ac.setcheckbox();
		 Ac.setcontinuebutton();
		 
		 logger.info("Validating expected result");
		String act= Ac.getConfirmationMsg();
		Assert.assertEquals(act, "Your Account Has Been Created!");
	}
		catch(Exception e)
		{
			Assert.fail();
			logger.error("Test is Failed");
		}
		logger.info("*** Completed TC_001_AccountRegistration ***");
	}
}
