package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
	//Declaration
	@FindBy(xpath = "//a[text()='Organizations']")
	private WebElement organisationLink;
	
	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement contactsLink;
	
	@FindBy(xpath = "//a[text()='Products']")
	private WebElement productLink;
	
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
	public WebElement getOrganisationLink() {
		return organisationLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignOutBtn() {
		return signOutBtn;
	}
	
	//Business Library
	/**
	 * This method will click on Organization link
	 */
	public void clickonOrganizationLink()
	{
		organisationLink.click();
	}
	/**
	 * This method will click on Contacts link
	 */
	public void clickonContactsLink()
	{
		contactsLink.click();
	}
	/**
	 * This method will click on Products link
	 */
	public void clickonProductsLink()
	{
		productLink.click();
	}
	/**
	 * This method will logout the application
	 * @param driver
	 * @param element
	 * @throws Throwable
	 */
	public void logoutOfApp(WebDriver driver) throws Throwable
	{
		mouseHoverAction(driver, administratorImg);
		Thread.sleep(1000);
		signOutBtn.click();
	}
}
