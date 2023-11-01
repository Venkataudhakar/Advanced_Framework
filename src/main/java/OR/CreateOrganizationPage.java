package OR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage
{
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrganisationImageLink;
	
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOrganisationImageLink() 
	{
		return createOrganisationImageLink;
	}
	
	public void clickOnCreateOrganisationImageLink()
	{
		createOrganisationImageLink.click();
	}
	
}
