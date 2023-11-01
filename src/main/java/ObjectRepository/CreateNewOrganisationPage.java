package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

public class CreateNewOrganisationPage extends WebDriverUtility
{
	//Declaration
	@FindBy(name = "accountname")
	private WebElement organizationNameEdt;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(name = "accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Initialization
	public CreateNewOrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getOrganizationNameEdt()
	{
		return organizationNameEdt;
	}

	public WebElement getIndustryDropDown() 
	{
		return industryDropDown;
	}

	public WebElement getTypeDropDown()
	{
		return typeDropDown;
	}

	public WebElement getSaveBtn() 
	{
		return saveBtn;
	}

	//Business Library
/**
 * This method will create new organization with mandatory fields
 * @param ORGNAME
 */
	public void createNewOrganization(String ORGNAME)
	{
		organizationNameEdt.sendKeys(ORGNAME);
		saveBtn.click();
	}
/**
 * This method will create new organization with Industry drop down	
 * @param ORGNAME
 * @param INDUSTRY
 */
	public void createNewOrganization(String ORGNAME, String INDUSTRY)
	{
		organizationNameEdt.sendKeys(ORGNAME);
		handleDropdown(industryDropDown, INDUSTRY);
		saveBtn.click();
	}
/**
* This method will create new organization with Industry and Type drop down	
* @param ORGNAME
* @param INDUSTRY
*/
	public void createNewOrganization(String ORGNAME, String INDUSTRY, String TYPE)
	{
		organizationNameEdt.sendKeys(ORGNAME);
		handleDropdown(industryDropDown, INDUSTRY);
		handleDropdown(typeDropDown, TYPE);
		saveBtn.click();
	}	
}
