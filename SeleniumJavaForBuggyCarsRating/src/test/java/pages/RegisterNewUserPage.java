package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utility.ConfigReader;

public class RegisterNewUserPage {

	private WebDriver driver;
	private ConfigReader configReaderObj;
	private WebDriverWait wait;

	@FindBy(xpath = "//*[text()='Register']")
	private WebElement btn_register;
	
	@FindBy(xpath = "//h2[text()='Register with Buggy Cars Rating']")
	private WebElement txt_registerWithBuggyCarsRating;
	
	@FindBy(xpath = "//*[@id='username']")
	private WebElement txt_userLoginName;
	
	@FindBy(xpath = "//*[@id='firstName']")
	private WebElement txt_firstName;
	
	@FindBy(xpath = "//*[@id='lastName']")
	private WebElement txt_lastName;
		
	@FindBy(xpath = "//input[@id='password']")
	private WebElement txt_password;
	
	@FindBy(xpath = "//input[@id='confirmPassword']")
	private WebElement txt_confirmPassword;

	@FindBy(xpath = "//button[text()='Register']")
	private WebElement btn_registerAfterUserDetails;
	
	@FindBy(xpath = "//div[@class='result alert alert-success']")
	private WebElement alert_registrationSuccessful;
	
	
	public RegisterNewUserPage(WebDriver driver) {
		this.driver = driver;
		configReaderObj = new ConfigReader();
		wait = new WebDriverWait(driver, configReaderObj.getImpliciteWaitTime());
		PageFactory.initElements(driver, this);
	}

	public void registerNewUser(String url,String LoginName, String FirstName,String LastName, String Password, String ConfirmPassowrd) throws InterruptedException {
		driver.get(url);	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		btn_register.click();
		wait.until(ExpectedConditions.visibilityOf(txt_registerWithBuggyCarsRating));
		txt_userLoginName.click();
		txt_userLoginName.sendKeys(LoginName);
		wait.until(ExpectedConditions.elementToBeClickable(txt_firstName));
		txt_firstName.click();
		txt_firstName.sendKeys(FirstName);
		wait.until(ExpectedConditions.elementToBeClickable(txt_lastName));
		txt_lastName.click();
		txt_lastName.sendKeys(LastName);
		wait.until(ExpectedConditions.elementToBeClickable(txt_password));
		txt_password.click();
		txt_password.sendKeys(Password);
		wait.until(ExpectedConditions.elementToBeClickable(txt_confirmPassword));
		txt_confirmPassword.click();
		txt_confirmPassword.sendKeys(ConfirmPassowrd);
		wait.until(ExpectedConditions.elementToBeClickable(btn_registerAfterUserDetails));
		btn_registerAfterUserDetails.click();
		Thread.sleep(3000);
		Assert.assertTrue(txt_registerWithBuggyCarsRating.isDisplayed(), "Registration Successful");

		}

}
