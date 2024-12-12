package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass   //getting data provider from diff class n LoginData is name of data provider
                                                 //if data provider is in same class..parameter 2 is not required.else need to specify it.
{
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)//dataProvider is present in separate package utilities and class ie in 2 parameter
	public void verify_loginDDT(String email,String pwd,String expresult) throws InterruptedException
	{
		//logger.info("****Starting TC003_loginTest_LoginDDT ****");
    	try
    	{	
			//Home Page
	    	HomePage hp=new HomePage(driver);
	    	hp.clickMyAccount();
	    	hp.clickLogin();
	    	
	    	//Login Page
	    	LoginPage lp=new LoginPage(driver);
	    	lp.setEmail(email);    
	    	lp.setPassword(pwd);
	    	lp.clickLogin();
	    	
	    	//MyAccount  	
	    	MyAccountPage macc=new MyAccountPage(driver);
	    	boolean targetPage=macc.isMyAccountPageExists();  //if targetPage value is true --login success if false login fail
	    	
	    	/*Data is valid----login success-- test pass---logout
	    	 *                 login failed----test fail---no logout
	    	 *
	    	 *
	    	 *Data is invalid ----- login success---test fail---logout
	    	 *                      login failed----test pass--no logout
	    	 */
	    	
	    	if(expresult.equalsIgnoreCase("Valid"))              //Valid case--- 2 scenarios
	    	{
	    		if(targetPage==true)  //login success
	    		{
	    			macc.clickLogout();      //After assertion no stmts will be executed.so inoreder to logout specify the stmnt b4 assert
	    			Assert.assertTrue(true);
	    			
	    		}
	    		else
	    		{
	    			Assert.assertTrue(false);
	    		}
	    	}
	    	
	    	if(expresult.equalsIgnoreCase("invalid"))              //inValid case--- 2 scenarios
	    	{
	    		if(targetPage==true)  //test fail
	    		{
	    			macc.clickLogout();      //After assertion no stmts will be executed.so inoreder to logout specify the stmnt b4 assert
	    			Assert.assertTrue(false);
	    			
	    		}
	    		else
	    		{
	    			Assert.assertTrue(true);   //test pass
	    		}
	    	}
    	}
			
	    catch(Exception e)
    	{
		    Assert.fail();
    	}
    	Thread.sleep(4000);
    	//logger.ingo("****Finished TC_003_loginDDT  *******);
    }

}
