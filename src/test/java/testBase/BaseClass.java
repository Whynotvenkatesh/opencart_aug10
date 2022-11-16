package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class BaseClass 
{
	
	public static WebDriver driver;
	
	 public Logger logger; //Logging file
	 
	 public ResourceBundle rb;
	
	@BeforeClass(groups = { "Master", "Sanity", "Regression" }) //Step8 groups added
	@Parameters("browser")
	public void set(String br)
	{
		
		rb=ResourceBundle.getBundle("Config");
		
	logger=LogManager.getLogger(this.getClass());
		
		//WebDriverManager.chromedriver().setup();
	if(br.equals("chrome"))
	{
		driver=new ChromeDriver();
	}
	else if(br.equals("edge"))
	{
		driver=new EdgeDriver();
	}
	else 
	{
		driver=new FirefoxDriver();
	}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("http://localhost/opencart/upload/");
		driver.get(rb.getString("appURL1"));
		driver.manage().window().maximize();
		
	}
	
	@AfterClass(groups = { "Master", "Sanity", "Regression" }) //Step8 groups added
	public void teardown()
	{
		driver.quit();
	}
	
	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

	public String randomeNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(9);
		return (generatedString2);
	}
	
	public String randomAlphaNumeric() {
		String string = RandomStringUtils.randomAlphabetic(4);
		String number = RandomStringUtils.randomNumeric(3);
		
		return (string+"@"+number);
	}
	
	
	//Screenshot method
	
	public String captureScreen(String tname) throws IOException {
		
		/*
		SimpleDateFormat df=new SimpleDateFormat();
		Date dt=new Date();
		String timeStamp=df.format(dt);
		
*/
		//return the Single line format
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
	
	
}