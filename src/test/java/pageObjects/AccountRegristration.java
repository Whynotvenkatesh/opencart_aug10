package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegristration extends Basepage 
{
 
	//Constructor
	public AccountRegristration(WebDriver driver)
	{
		super(driver);
	}
	
	//Elements
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement Firstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement Lastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement Emailid;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement Telephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement Confirmpassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement checkbox;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continuebutton;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	
	//Actions Method
	
	public void setFirstname(String fname)
	{
		Firstname.sendKeys(fname);
	}
	
	public void setLastname(String lname)
	{
		Lastname.sendKeys(lname);
	}
	
	public void SetEmailid(String Email)
	{
	Emailid.sendKeys(Email);	
	}
	public void setTelephone(String Tphone)
	{
		Telephone.sendKeys(Tphone);
	}
	public void setpassword(String psswrd)
	{
		password.sendKeys(psswrd);
	}
	public void setConfirmpassword(String cnfrmpswrd)
	{
		Confirmpassword.sendKeys(cnfrmpswrd);
	}
	public void setcheckbox()
	{
		checkbox.click();
	}
	
public void setcontinuebutton()
{
	continuebutton.click();
}
public String getConfirmationMsg() {
	try {
		return (msgConfirmation.getText());
	} catch (Exception e) {
		return (e.getMessage());

	}

}
}