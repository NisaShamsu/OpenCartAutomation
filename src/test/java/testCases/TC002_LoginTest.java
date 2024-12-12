package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass
{
    @Test
	public void verify_login() 
    {
    	//logger.info("****Starting TC002_loginTest****");
    	try
    	{
	    	//Home Page
	    	HomePage hp=new HomePage(driver);
	    	hp.clickMyAccount();
	    	hp.clickLogin();
	    	
	    	//Login Page
	    	LoginPage lp=new LoginPage(driver);
	    	lp.setEmail("nisashamsu@gmail.com");    
	    	lp.setPassword("Nisashamsu123#");
	    	lp.clickLogin();
	    	
	    	//lp.setEmail(p.getProperty("email"));   using log file  
	        //lp.setPasswor(p.getProperty("password")); lp.clickLogin();
	    	
	    	//MyAccount
	    	
	    	MyAccountPage macc=new MyAccountPage(driver);
	    	boolean targetPage=macc.isMyAccountPageExists();
	    	
	    	//Assert.assertTrue(targetPage);
	    	Assert.assertEquals(targetPage, true, "Login Failed");   
	    	
	    	//logger.info("****Finished TC002_loginTest****");
    	}
    	catch(Exception e)
    	{
    		Assert.fail();
    	}   	
	}
}
