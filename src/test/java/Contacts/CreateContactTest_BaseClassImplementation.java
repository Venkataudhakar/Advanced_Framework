package Contacts;

import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import ObjectRepository.ContactsInfoPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateNewContactPage;
import ObjectRepository.HomePage;

public class CreateContactTest_BaseClassImplementation extends BaseClass
{
	@Test
	public void createContactTest() throws Throwable
	
	{
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 1, 2);
		
		HomePage hp = new HomePage(driver);
		hp.clickonContactsLink();
		
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookupImg();
		
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME);
		
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String contactHeader = cip.getContactsHeaderText();
		
		if (((String) contactHeader).contains(LASTNAME)) 
		{
			System.out.println(LASTNAME);
			System.out.println("PASS");
		} 
		else
		{
			System.out.println("FAIL");
		}
	}
}
