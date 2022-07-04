package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
        PageFactory.initElements(driver, this);
	}
	//locators+identification
	@FindBy(name="email")
	WebElement txtemail;
	@FindBy(name="password")
	WebElement txtpassword;
	@FindBy(xpath="//input[@value='Login']")
	WebElement clogin;
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msgHeading;
	public void setEmail(String email) {
		txtemail.sendKeys(email);
	}
	public void setPassword(String pswd) {
		txtpassword.sendKeys(pswd);
	}
	public void clickLogin() {
		clogin.click();
	}
	public boolean MyAccountPageExists() {
		try {
		return(msgHeading.isDisplayed());
		}
		catch(Exception e){
			return(false);
		}
	}
	
	
}
