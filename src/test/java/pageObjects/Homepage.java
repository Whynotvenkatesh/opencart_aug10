package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage
{
	//Constructor
	public Homepage(WebDriver driver)
	{
		super(driver);
	}

	//Elements
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement myaccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement Registration;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	WebElement Login;
	
	//Actions methods
	
	public void myaccountclick()
	{
		myaccount.click();
	}
	
	public void registrationclick()
	{
		Registration.click();
	}
	
	public void Loginclick()
	{
		Login.click();
	}
}
