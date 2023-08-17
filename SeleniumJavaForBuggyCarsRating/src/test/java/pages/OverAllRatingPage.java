package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utility.ConfigReader;

public class OverAllRatingPage {

	private WebDriver driver;
	private ConfigReader configReaderObj;
	private WebDriverWait wait;

		
	@FindBy(xpath = "//img[@src='/img/overall.jpg']")
	private WebElement link_overAllRating;
	
	@FindBy(xpath = "//a[text()='Engine']")
	private WebElement link_sortEngineCapacity;
	
	@FindBy(xpath = "//img[@title='Launch Ypsilon']")
	private WebElement img_Lancia;
	
	public OverAllRatingPage(WebDriver driver) {
		this.driver = driver;
		configReaderObj = new ConfigReader();
		wait = new WebDriverWait(driver, configReaderObj.getImpliciteWaitTime());
		PageFactory.initElements(driver, this);
	}

	public void verifyVehicleDisplayPostSortingEngineCapacity(String url) throws InterruptedException {
		driver.get(url);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(link_overAllRating));
		link_overAllRating.click();
		Actions at = new Actions(driver);
		at.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(10000);
		link_sortEngineCapacity.click();
		Thread.sleep(500);
		Assert.assertTrue(img_Lancia.isDisplayed(),"Image displayed");
		}

}
