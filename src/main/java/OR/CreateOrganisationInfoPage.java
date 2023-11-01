package OR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganisationInfoPage 
{
	@FindBy(className = "dvHeaderText")
	private WebElement orgHeaderText;
	
	public CreateOrganisationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgHeaderText() {
		return orgHeaderText;
	}
	
	
	public String getOrganisationHeaderText()
	{
		return orgHeaderText.getText();
	}
}
