package OR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

/**
 * This class contains the address of the Web Elements present on the Home Page
 * @author user
 *
 */
public class HomePage extends WebDriverUtility
{
	//Declation
	@FindBy(xpath = "//a[text()='Organizations']")
	private WebElement organisationLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOutBtn;
	
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getOrganisationLink() 
	{
		return organisationLink;
	}

	public WebElement getAdministratorImg()
	{
		return administratorImg;
	}
	public WebElement getSignOutBtn() 
	{
		return signOutBtn;
	}
	
	//Business Library
/**
 * This method will click on the Organisation Link
 */
	public void clickOnOrganisationLink()
	{
		organisationLink.click();
	}
/**
 * This method will log out the application
 * @throws Throwable
 */
	public void logOut(WebDriver driver) throws Throwable
	{
		mouseHoverAction(driver, administratorImg);
		Thread.sleep(2000);
		signOutBtn.click();
	}
}
