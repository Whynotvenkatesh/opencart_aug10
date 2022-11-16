package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Basepage
{
	
	public Loginpage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement Emailid;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement login;
	
	public void setemail(String email)
	{
		Emailid.sendKeys(email);
	}
	public void setpassword(String psword)
	{
		password.sendKeys(psword);
	}

	public void loginclick()
	{
		login.click();
	}
}
