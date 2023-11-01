package Contacts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.WebDriverUtility;
import ObjectRepository.ContactsInfoPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateNewContactPage;
import ObjectRepository.CreateNewOrganisationPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrganisationInfoPage;
import ObjectRepository.OrganisationsPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrganizationTest
{
	@Test(groups = {"SmokeSuite","RegressionSuite"})
	public void createContactWithOrgTest() throws Throwable
	{
		//Step 1: Create all the required objects
				ExcelFileUtility eutil = new ExcelFileUtility();
				PropertyFileUtility putil = new PropertyFileUtility();
				JavaUtility jUtil = new JavaUtility();
				WebDriverUtility wUtil = new WebDriverUtility();
				
				//Step 2: Read the required data
				String BROWSER = putil.readDataFromPropertyFile("browser");
				String URL = putil.readDataFromPropertyFile("url");
				String USERNAME = putil.readDataFromPropertyFile("username");
				String PASSWORD = putil.readDataFromPropertyFile("password");
				
				String ORGNAME = eutil.readDataFromExcel("Organisation", 1, 2) + jUtil.getRandomNumber();
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
				hp.clickonOrganizationLink();
				
				OrganisationsPage op = new OrganisationsPage(driver);
				op.clickOnOrganisationLookUpImg();
				
				CreateNewOrganisationPage cnop = new CreateNewOrganisationPage(driver);
				cnop.createNewOrganization(ORGNAME);
				
				OrganisationInfoPage oip = new OrganisationInfoPage(driver);
				String OrgHeader = oip.getHeaderText();
				
				Assert.assertTrue(OrgHeader.contains(ORGNAME));
				System.out.println(OrgHeader);
			/*
				if (OrgHeader.contains(ORGNAME))
				{
					System.out.println(OrgHeader);
					System.out.println("Organization Created Successfully");
				} 
				else
				{
					System.out.println("FAIL");
				}
			*/	
				hp.clickonContactsLink();
				
				ContactsPage cp = new ContactsPage(driver);
				cp.clickOnCreateContactLookupImg();
				
				CreateNewContactPage cncp = new CreateNewContactPage(driver);
				cncp.createNewContact(driver, ORGNAME, LASTNAME);
				
				ContactsInfoPage cip = new ContactsInfoPage(driver);
				String contactHeader = cip.getContactsHeaderText();
				
				if (contactHeader.contains(LASTNAME))
				{
					System.out.println(contactHeader);
					System.out.println("PASS");
				}
				else
				{
					System.out.println("FAIL");
				}
				
				hp.logoutOfApp(driver);
				driver.quit();
	}
}
