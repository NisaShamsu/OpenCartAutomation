package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
	   public LoginPage(WebDriver driver) 
	   {
		super(driver);	
	   }
	   
	   @FindBy(xpath="")
	   WebElement txtEmailAddress;
	   
	   @FindBy(xpath="")
	   WebElement txtPassword;
	   
	   @FindBy(xpath="")
	   WebElement btnLogin;
	   
	   public void setEmail(String email) {
		   txtEmailAddress.sendKeys(email);
	   }
	   
	   public void setPassword(String pwd) {
		   txtPassword.sendKeys(pwd);
	   }
	   public void clickLogin() {
		   btnLogin.click();
	   }
}
