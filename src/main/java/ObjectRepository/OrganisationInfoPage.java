package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInfoPage
{
	//Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement orgHeaderText;
	
	//Initialization
	public OrganisationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement getOrgHeaderText() 
	{
		return orgHeaderText;
	}
	
	//Business Library
/**
 * This method will capture the Organization Header Text and return it to the aller
 * @return
 */
	public String getHeaderText()
	{
		return orgHeaderText.getText();
	}
}
