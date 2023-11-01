package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	//Step 2: Declaration
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']")})
	private WebElement loginBtn;
	
	//Step 3: Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Step 4: Utilization
	public WebElement getUserNameEdt() 
	{
		return userNameEdt;
	}

	public WebElement getPasswordEdt()
	{
		return passwordEdt;
	}

	public WebElement getLoginBtn() 
	{
		return loginBtn;
	}
	
	//Step 5: Business Library - Generic methods according to the need of project
	
	public void loginToApp(String USERNAME, String PASSWORD)
	{
		userNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}
}
