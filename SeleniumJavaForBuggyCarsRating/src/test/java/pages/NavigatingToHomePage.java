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

public class NavigatingToHomePage {

	private WebDriver driver;
	private ConfigReader configReaderObj;
	private WebDriverWait wait;

		
	@FindBy(xpath = "//*[@title='Alfa Romeo']")
	private WebElement link_popularMake;
		
	@FindBy(xpath = "//a[text()='Buggy Rating']")
	private WebElement link_buggyRating;
	
	@FindBy(xpath = "//h2[text()='Popular Make']")
	private WebElement txt_popularMakeInHomePage;
	
	public NavigatingToHomePage(WebDriver driver) {
		this.driver = driver;
		configReaderObj = new ConfigReader();
		wait = new WebDriverWait(driver, configReaderObj.getImpliciteWaitTime());
		PageFactory.initElements(driver, this);
	}

	public void navigateToHomePage(String url) throws InterruptedException {
		driver.get(url);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(link_popularMake));
		link_popularMake.click();
		Thread.sleep(10000);
		link_buggyRating.click();
		Thread.sleep(500);
		Assert.assertTrue(txt_popularMakeInHomePage.isDisplayed(),"Navigated to Home Page");
		}

}
