package pages;

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

public class SignInPage {

	private WebDriver driver;
	private ConfigReader configReaderObj;
	private WebDriverWait wait;

	@FindBy(xpath = "//input[@name='login']")
	private WebElement txt_userName;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement txt_password;

	@FindBy(xpath = "//button[text()='Login']")
	private WebElement btn_LogIn;
	
	@FindBy(xpath = "//h1[text()='Buggy']")
	private WebElement txt_Buggy;
	
	@FindBy(xpath = "//h2[text()='Register with Buggy Cars Rating']")
	private WebElement txt_registerWithBuggyCarsRating;
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		configReaderObj = new ConfigReader();
		wait = new WebDriverWait(driver, configReaderObj.getImpliciteWaitTime());
		PageFactory.initElements(driver, this);
	}

	public void openBeggyCarsPortal(String url, String UserName, String Password) throws InterruptedException {
		txt_userName.sendKeys(UserName);
		wait.until(ExpectedConditions.elementToBeClickable(txt_password));
		txt_password.click();
		txt_password.sendKeys(Password);
		System.out.println(Password);
		wait.until(ExpectedConditions.elementToBeClickable(btn_LogIn));
		btn_LogIn.click();
		Thread.sleep(10000);
		Assert.assertFalse(txt_registerWithBuggyCarsRating.isDisplayed());
		}

}
