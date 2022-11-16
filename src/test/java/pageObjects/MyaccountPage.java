package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyaccountPage extends Basepage
{
	public MyaccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement myaccount;
	
	
	//@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
	//WebElement Logout;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement Logout;
	
	public boolean myaccountheading()
	{
		try
		{
			return(myaccount.isDisplayed());	
		}
		catch(Exception e)
		{
			return (false);
		}
		
	}

	public void logoutbutton()
	{
		Logout.click();
	}
	
	
}
