package Contacts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import GenericUtilities.ExcelFileUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.WebDriverUtility;
import ObjectRepository.ContactsInfoPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateNewContactPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(GenericUtilities.ListenerImplementationClass.class)
public class CreateContactITestListener extends BaseClass
{
	@Test
	public void createContactTest() throws Throwable
	
	{
		//Step 1: Create all the required objects
		ExcelFileUtility eutil = new ExcelFileUtility();
		PropertyFileUtility putil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		//Step 2: Read the required data
		String BROWSER = putil.readDataFromPropertyFile("browser");
		String URL = putil.readDataFromPropertyFile("url");
		String USERNAME = putil.readDataFromPropertyFile("username");
		String PASSWORD = putil.readDataFromPropertyFile("password");
		
		String LASTNAME = eutil.readDataFromExcel("Contacts", 1, 2);
		
		WebDriver driver=null;	
		if (BROWSER.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Chrome browser launched");
		} 
		else if (BROWSER.equalsIgnoreCase("Edge")) 
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("Edge browser launched");
		} 
		else if (BROWSER.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Firefox browser launched");
		}
		else 
		{
			System.out.println("Invalid browser name");
		}
		
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		
		driver.get(URL);
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		HomePage hp = new HomePage(driver);
		hp.clickonContactsLink();
		
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookupImg();
		
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME);
		
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String contactHeader = cip.getContactsHeaderText();
		
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		//Assert.fail();
		System.out.println(contactHeader);
	/*
		if (((String) contactHeader).contains(LASTNAME)) 
		{
			System.out.println(LASTNAME);
			System.out.println("PASS");
		} 
		else
		{
			System.out.println("FAIL");
		}
	*/	
		hp.logoutOfApp(driver);
		System.out.println("Logout successfully");
		
		driver.quit();
	}
}
