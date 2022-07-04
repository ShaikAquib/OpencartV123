//login
package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_Login extends BaseClass {

	@Test(groups= {"sanity","master"})
	public void test_login() throws IOException {
		
		logger.info("Starting TC_002_Login");
		try {
			driver.get(rb.getString("appURL"));
			logger.info("Home page Displayed");
			driver.manage().window().maximize();
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("clicked on myaccount");
			hp.clickLogin();
			logger.info("clicked on login");
		    LoginPage lp=new LoginPage(driver);
		    lp.setEmail(rb.getString("email"));
		   // lp.setEmail("aquib@gmail.com");
		    logger.info("Provided email");
		    lp.setPassword(rb.getString("password"));
		    logger.info("Provided password");
		    lp.clickLogin();
		    logger.info("clicked on login page login button");
		    boolean targetpage = lp.MyAccountPageExists();   // returns true or false
		    if(targetpage) {          // if true this block executes
		    	logger.info("Login passed");
		    	Assert.assertTrue(true);
		    }
		    else {    // false this block gets executes
		    	logger.error("Login failed");
		    	captureScreen(driver,"test_login");
		    	Assert.assertTrue(false);
		    }
		  
		}
		catch(Exception e) {
			captureScreen(driver,"test_login");
			Assert.fail();
		}
	}
}
