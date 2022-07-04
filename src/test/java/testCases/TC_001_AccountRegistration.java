package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
public class TC_001_AccountRegistration extends BaseClass {    
	@Test(groups= {"regression", "master"})
	public void test_account_registration()
	{
		logger.debug("debug logging");
		logger.info("Starting TC_001_AccountRegistration");
		try {
			
	    logger.info("Launching Application");
			
		driver.get(rb.getString("appURL"));   // specifying the appURL from config.properties instead of complete URL
		driver.manage().window().maximize();
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		logger.info("Clicked on myaccount & register link");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName("S MD AQUIB");
		logger.info("Provided firstname");
		regpage.setLastName("AHMED");
		logger.info("Provided lastname");
		regpage.setEmail(randomestring()+"@gmail.com");
		//regpage.setEmail("abc");
		logger.info("Provided email");
		regpage.setTelephone("8143199087");
		logger.info("Provided mobile");
		regpage.setPassword("aquib123");
		regpage.setConfirmPassword("aquib123");
		logger.info("Provided pswd & confirm pswd");
		regpage.clickAgree();
		regpage.clickContinue();
		logger.info("Clicked on continue button");
		if(regpage.msgDisplayed().equals("Your Account Has Been Created!"))
		{
			logger.info("Registration test passed");
			Assert.assertTrue(true);
		}
		else {
			captureScreen(driver,"test_account_registration");  // non-static method can be called directly
			logger.error("Registration test failed");
			Assert.assertTrue(false);
		}
	/*	if(driver.getTitle().equals("My Account")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		} */
		}
		catch(Exception e) {
			logger.fatal("Registration test blocked");
			Assert.fail();
		}
	}
	
}
