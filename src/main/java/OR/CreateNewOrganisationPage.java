package OR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.WebDriverUtility;

public class CreateNewOrganisationPage extends WebDriverUtility
{
	@FindBy(name = "accountname")
	private WebElement organisationNameEdt;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateNewOrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganisationNameEdt() {
		return organisationNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}
			
	public WebElement getSaveBtn() 
	{
		return saveBtn;
	}

	public void createNewOrganisation(String ORGNAME, String INDUSTRYNAME)
	{
		organisationNameEdt.sendKeys(ORGNAME);
		handleDropdown(industryDropDown, INDUSTRYNAME);
		saveBtn.click();
	}
}
