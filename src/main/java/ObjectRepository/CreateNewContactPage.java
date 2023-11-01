package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility
{
	//Declaration
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//img[@alt='Select']")
	private WebElement orgLookUpImg;
	
	@FindBy(name = "search_text")
	private WebElement orgSearchEdt;
	
	@FindBy(name = "search")
	private WebElement SearchNowBtn;
	
	//Initialization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getLastNameEdt() 
	{
		return lastNameEdt;
	}

	public WebElement getSaveBtn()
	{
		return saveBtn;
	}

	public WebElement getOrgLookUpImg() 
	{
		return orgLookUpImg;
	}

	public WebElement getOrgSearchEdt()
	{
		return orgSearchEdt;
	}

	public WebElement getSearchNowBtn()
	{
		return SearchNowBtn;
	}
/**
 * This method will create the new contact with Mandatory fields and save	
 * @param LASTNAME
 */
	//Business Library
	public void createNewContact(String LASTNAME)
	{
		lastNameEdt.sendKeys(LASTNAME);
		saveBtn.click();
	}
/**
 * This method will create contact with organization
 * @param driver
 * @param ORGNAME
 * @param LASTNAME
 */
	public void createNewContact(WebDriver driver, String ORGNAME, String LASTNAME)
	{
		lastNameEdt.sendKeys(LASTNAME);
		orgLookUpImg.click();
		switchToWindow(driver, "Accounts");
		orgSearchEdt.sendKeys(ORGNAME);
		SearchNowBtn.click();
		driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();
		switchToWindow(driver, "Contacts");
		saveBtn.click();
	}
}
