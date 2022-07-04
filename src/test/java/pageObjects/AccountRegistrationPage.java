package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistrationPage {

	WebDriver driver;
	public AccountRegistrationPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="firstname")
	WebElement txtFirstName;
	@FindBy(name="lastname")
	WebElement txtLastName;
	@FindBy(name="email")
	WebElement txtEmail;
	@FindBy(name="telephone")
	WebElement txtTelephone;
	@FindBy(name="password")
	WebElement txtPassword;
	@FindBy(name="confirm")
	WebElement txtConfirmPassword;
	//@FindBy(name="newsletter")
	//WebElement txtNewsLetter;
	@FindBy(xpath="//input[@name='agree']")
	WebElement txtAgree;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement txtContinue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement txtRegConfirmation;
	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}
	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	public void setTelephone(String telephone) {
		txtTelephone.sendKeys(telephone);
	}
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	public void setConfirmPassword(String cpwd) {
		txtConfirmPassword.sendKeys(cpwd);
	}
	/*public void clickNewsLetter() {
		txtNewsLetter.click();
	} */
	public void clickAgree() {
		txtAgree.click();
	}
	public void clickContinue() {
		txtContinue.click();
	}
	public String msgDisplayed() {
		try {
		return(txtRegConfirmation.getText());
		}
		catch (Exception e){
			return(e.getMessage());
		}
	}
}
