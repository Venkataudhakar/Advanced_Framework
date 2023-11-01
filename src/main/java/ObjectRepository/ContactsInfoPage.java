package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage
{
	//Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactHeaderText;
	
	//Initialization
	public ContactsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getContactHeaderText() 
	{
		return contactHeaderText;
	}
/**
 * This method will capture the Contacts Header Text and return it to the caller	
 * @return
 */
	//Business Library
	public String getContactsHeaderText()
	{
		return contactHeaderText.getText();
	}
}

