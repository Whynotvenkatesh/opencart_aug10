package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.MyaccountPage;
import testBase.BaseClass;

public class TC_002_Logintest extends BaseClass
{
	
	@Test(groups= {"Sanity","Master"}) //Step8 groups added
	public void test_login()
	{
		try
		{
		logger.info("*** Started TC_002_logintest ***");
		Homepage hp=new Homepage(driver);
		
		logger.info("clicked on myaccount");
		hp.myaccountclick();
		
		logger.info("clicked on login");
		hp.Loginclick();
		
		Loginpage lp=new Loginpage(driver);
		
		logger.info("provide the login datat");
		lp.setemail(rb.getString("email"));
		lp.setpassword(rb.getString("password"));
		lp.loginclick();
		
		MyaccountPage my=new MyaccountPage(driver);
		
		logger.info("validating the valid message");
		boolean result=my.myaccountheading();
		
		Assert.assertEquals(result,true);
	}
		catch(Exception e)
		{
			Assert.fail();
		}

		logger.info("*** completed TC_002_logintest ***");
	}
}
