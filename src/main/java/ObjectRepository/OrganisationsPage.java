package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationsPage
{
	//Declaration
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrgLookUpImg;
	
	//Initialization
	public OrganisationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getCreateOrgLookUpImg()
	{
		return createOrgLookUpImg;
	}
	
/**
 * This method will click on Create Organization Lookup Image
 */
	//Business Library
	public void clickOnOrganisationLookUpImg()
	{
		createOrgLookUpImg.click();
	}
}
