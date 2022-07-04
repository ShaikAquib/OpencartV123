package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    //global variable declaration at class level
	WebDriver driver;
	//constructor
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	// locators+identification
	@FindBy(xpath="//span[text()='My Account']")
	WebElement lnkMyAccount;
	@FindBy(linkText="Register")
	WebElement lnkRegister;
	@FindBy(linkText="Login")
	WebElement lnkLogin;
	public void clickMyAccount() {
		lnkMyAccount.click();
	}
	public void clickRegister() {
		lnkRegister.click();
	}
	public void clickLogin() {
		lnkLogin.click();
	}
	
}
