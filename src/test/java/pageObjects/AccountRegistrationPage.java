package pageObjects;
//import java.time.Duration;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage
{

	public AccountRegistrationPage(WebDriver driver) 
	{
		super(driver);
		
	}
/*	
FindByXpath("//input[@id='input-firstname']")
FindByXpath("//input[@id='input-lastname']")
FindByXpath("//input[@id='input-email']")
FindByXpath("//input[@id='input-telephone']")
FindByXpath("//input[@id='input-password']")
FindByXpath("//input[@id='input-confirm']")
FindByXpath("//label[normalize-space()='Yes']")
FindByXpath("//input[@value='0']")
FindByXpath("//input[@name='agree']")
FindByXpath("//input[@value='Continue']")
*/		
	@FindBy(xpath ="//input[@id='input-firstname']")
	WebElement txtFirstname;
		
	@FindBy(xpath ="//input[@id='input-lastname']")
	WebElement txtLastname;
	
	@FindBy(xpath ="//input[@id='input-email']")
	WebElement txtEmail;
		
	@FindBy(xpath ="//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath ="//input[@id='input-password']")
	WebElement txtPassword;
		
	@FindBy(xpath ="//input[@id='input-confirm']")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath ="//input[@name='agree']")
	WebElement chkdPolicy;
	
	@FindBy(xpath ="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath ="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setFirstName(String fname)
	{
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String telephone )
	{
		txtTelephone.sendKeys(telephone);
	}
	
	public void setPassword(String paswd)
	{
		txtPassword.sendKeys(paswd);
	}
	
	public void setConfirmPassword(String ConfPaswd )  //Same parameter paswd and ConfPaswd can be same
	{
		txtConfirmPassword.sendKeys(ConfPaswd);
	}
	
	public void setPolicy()
	{
		chkdPolicy.click();
	}
	
	public void clickBtnContinue()
	{
		//Sol 1
		btnContinue.click();
	}
		
		//Sol 2
		//btnContinue.submit();
		
		//Sol 3
		//Actions act=new Actions(driver);
		//act.moveToElement(btnContinue).click().perform();
		
		//Sol 4
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", btnContinue);
		
		
		//Sol 5
		//btnContinue.sendKeys(Keys.RETURN);
			
		//Sol 6
		//WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
	
	
	public String getConfirmationMsg()
	{
		try
		{
			return (msgConfirmation.getText());
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}	

}
