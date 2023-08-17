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
import pages.OverAllRatingPage;
import testbase.BaseTest;
import utility.ConfigReader;
import utility.DriverUtils;

public class OverAllRatingTest extends BaseTest {

	private WebDriver driver;
	private RegisterNewUserPage RegisterNewUserObj;
	private SignInPage SignInPageObj;
	private NavigatingToHomePage NavigatingToHomePageObj;
	private OverAllRatingPage OverAllRatingTestObj;
	
	private ConfigReader configReader;
	private String url;

	public OverAllRatingTest() {
		configReader = new ConfigReader();
		url = configReader.getTestURL();
	}
	
	@BeforeTest()
	public void setupInitial() {
		driver = new DriverUtils().getDriver();
		RegisterNewUserObj = new RegisterNewUserPage(driver);
		SignInPageObj = new SignInPage(driver);
		NavigatingToHomePageObj = new NavigatingToHomePage(driver);
		OverAllRatingTestObj = new OverAllRatingPage(driver);
		
	}
	
	

	/*
	 *This method will verify the image display after sorting the Engine Capacity
	 */
	@Test(dataProvider = "getTestData",priority = 1, enabled = true,description= "To verify the image display after sorting the Engine Capacity")
	public void verifyVehicleImageDisplayAfterSortingByEngineCapacity(ITestContext context) throws Throwable {
		driver = new DriverUtils().getDriver();
		OverAllRatingTestObj.verifyVehicleDisplayPostSortingEngineCapacity(url);
        test.log(Status.PASS, MarkupHelper.createLabel("Successfully able to verify the image display after sorting the Engine Capacity", ExtentColor.GREEN));
			
	}

	
	
	
}

	
		
	
		


	