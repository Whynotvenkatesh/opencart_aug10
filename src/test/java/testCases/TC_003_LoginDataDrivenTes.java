package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.MyaccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDataDrivenTes extends BaseClass

{
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void test_LoginDataDriven(String email,String password,String expectedvalue)
	{
		logger.info("** Starting TC_003_LoginDataDrivenTes ***");
		
		try
		{
			
        Homepage hp=new Homepage(driver);
        
		hp.myaccountclick();
		hp.Loginclick();
		
		Loginpage lp=new Loginpage(driver);
		
		lp.setemail(email);
		lp.setpassword(password);
		lp.loginclick();
		
		
		//Validation 
        MyaccountPage my=new MyaccountPage(driver);
		boolean result=my.myaccountheading();
		
		
		if(expectedvalue.equals("Valid"))
		{
			if(result==true)
			{
				my.logoutbutton();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.fail();  //Assert.asserTrue(false);
			}
		}
		
		if(expectedvalue.equals("Invalid"))
		{
			
			if(result==true)
			{
				my.logoutbutton();
				Assert.assertTrue(false);
			}
			else
			{
			 Assert.assertTrue(true);
			}
		}
		
		}catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("** completed TC_003_LoginDataDrivenTest ***");	
	}
}
