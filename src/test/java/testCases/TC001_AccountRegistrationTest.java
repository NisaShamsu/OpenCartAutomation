package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass
{
	/*
	 * kept in another separate test base class to receive multiple times in multiple test cases
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
      */  
      
    @Test
      public void verify_account_registration()
      {
    	HomePage hp=new HomePage(driver);
    	hp.clickMyAccount();
    	hp.clickRegister(); 	
    	
    	AccountRegistrationPage regPage=new AccountRegistrationPage(driver);
    	
    	//regPage.setFirstName("Nisa");
    	//regPage.setLastName("Shinil");
    	//regPage.setEmail("nisashinil@gmail.com");  //Static test data
    	//regPage.setTelephone("4285361256");
    	//regPage.setPassword("abc123#");
    	
    	
    	regPage.setFirstName(randomString().toUpperCase());
    	regPage.setLastName(randomString().toUpperCase());   	
    	regPage.setEmail(randomString()+"@gmail.com");  //random generated data by user 	
    	regPage.setTelephone(randomNumber());
    	
    	
    	String password=randomPassword();  //assign the firstly generated password in a string variable inorder to pass the same value im confirm password  
    	regPage.setPassword(password);
    	regPage.setConfirmPassword(password);  //coz it needs to be same always.
    	
    	regPage.setPolicy();
    	regPage.clickBtnContinue();
    	
    	String confmsg=regPage.getConfirmationMsg();
    	Assert.assertEquals(confmsg, "Your Account Has Been Created!");
      }
    
    /*
    
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
	*/
    /*@SuppressWarnings("deprecation")
	public String randomPassword() 
    {
    	String generatedPassword= RandomStringUtils.randomAlphanumeric(10);
    	return generatedPassword;    	
    }*/	
    
}
