package OR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	@FindBy(name = "user_name")
	private WebElement userNameEdt;
	
	@FindBy(name = "user_password")
	private WebElement passWordEdt;
	
	@FindBy(id = "submitButton")
	private WebElement submitBtn;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPassWordEdt() {
		return passWordEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public void loginToApp(String USERNAME, String PASSWORD)
	{
		userNameEdt.sendKeys(USERNAME);
		passWordEdt.sendKeys(PASSWORD);
		submitBtn.click();
	}
}
