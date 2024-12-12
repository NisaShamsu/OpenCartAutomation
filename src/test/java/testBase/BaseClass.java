package testBase;

import java.time.Duration;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass 
{
         //Commonly used methods in multiple test cases are been created in a separate class called base class
	public WebDriver driver;
	@BeforeClass	
    public void setUP() 
    {
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://tutorialsninja.com/demo/index.php");
		driver.manage().window().maximize();  	  
    }
	
	 @AfterClass
   public void tearDown()
    {
		 driver.quit();
  	  
    }
	 
	 @SuppressWarnings("deprecation")
		public String randomString() 
	    {
	    	String generatedString= RandomStringUtils.randomAlphabetic(5);
	    	return generatedString;    	
	    }
		
		@SuppressWarnings("deprecation")
		public String randomNumber() 
	    {
	    	String generatedNumber= RandomStringUtils.randomNumeric(10);
	    	return generatedNumber;    	
	    }
	    	
		@SuppressWarnings("deprecation")
		public String randomPassword() 
	    {
			String generatedString= RandomStringUtils.randomAlphabetic(3);
			String generatedNumber= RandomStringUtils.randomNumeric(6);
			return (generatedString+"@"+generatedNumber);
	    }
}
