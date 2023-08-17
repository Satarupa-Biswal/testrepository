package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import org.testng.Assert;
import org.testng.ITestContext;

import pages.RegisterNewUserPage;
import pages.SignInPage;
import testbase.BaseTest;
import utility.ConfigReader;
import utility.DriverUtils;

public class SignInTest extends BaseTest {

	private WebDriver driver;
	private RegisterNewUserPage RegisterNewUserObj;
	private SignInPage SignInPageObj;
	
	private ConfigReader configReader;
	private String url;

	public SignInTest() {
		configReader = new ConfigReader();
		url = configReader.getTestURL();
	}
	
	@BeforeTest()
	public void setupInitial() {
		driver = new DriverUtils().getDriver();
		RegisterNewUserObj = new RegisterNewUserPage(driver);
		SignInPageObj = new SignInPage(driver);
		
	}
	
	
	/*
	 *This method will verify the Log-In into Buggy Cars Rating Application by taking the inputs as User name and Password
	 */
	@Test(dataProvider = "getTestData",priority = 1, enabled = true,description= "To verify the Log-In Into Buggy Cars Rating Application Application")
	public void verifyLoginIntoBuggyCarsRatingApp(ITestContext context,String LoginName, String FirstName,String LastName,
			String UserName,String Password,String ConfirmPassowrd) throws Throwable {
		driver = new DriverUtils().getDriver();
		RegisterNewUserObj.registerNewUser(url, LoginName,FirstName,LastName, Password,ConfirmPassowrd);
        SignInPageObj.openBeggyCarsPortal(url, UserName, Password);
        
        test.log(Status.PASS, MarkupHelper.createLabel("Sign In  is successful into Buggy Cars Rating Application Application", ExtentColor.GREEN));
			
	}

	
	
	
}

	
		
	
		


	