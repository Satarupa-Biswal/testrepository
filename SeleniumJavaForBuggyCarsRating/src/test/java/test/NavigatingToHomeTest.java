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
import pages.NavigatingToHomePage;
import testbase.BaseTest;
import utility.ConfigReader;
import utility.DriverUtils;

public class NavigatingToHomeTest extends BaseTest {

	private WebDriver driver;
	private RegisterNewUserPage RegisterNewUserObj;
	private SignInPage SignInPageObj;
	private NavigatingToHomePage NavigatingToHomePageObj;
	
	
	private ConfigReader configReader;
	private String url;

	public NavigatingToHomeTest() {
		configReader = new ConfigReader();
		url = configReader.getTestURL();
	}
	
	@BeforeTest()
	public void setupInitial() {
		driver = new DriverUtils().getDriver();
		RegisterNewUserObj = new RegisterNewUserPage(driver);
		SignInPageObj = new SignInPage(driver);
		NavigatingToHomePageObj = new NavigatingToHomePage(driver);
		
		
	}
	
	

	/*
	 *This method will verify the navigation to Buggy Cars Rating Application Home Page
	 */
	@Test(dataProvider = "getTestData",priority = 1, enabled = true,description= "To verify the navigation to Buggy Cars Rating Application Home Page")
	public void verifyNavigationToHomePage(ITestContext context) throws Throwable {
		driver = new DriverUtils().getDriver();
        NavigatingToHomePageObj.navigateToHomePage(url);
        
        test.log(Status.PASS, MarkupHelper.createLabel("Successfully able to verify the navigation to Buggy Cars Rating Application Home Page", ExtentColor.GREEN));
			
	}

	
	
	
}

	
		
	
		


	