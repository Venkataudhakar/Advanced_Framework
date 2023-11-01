package Sample;

import org.testng.annotations.Test;

import GenericUtilities.BaseClass1;
import OR.CreateOrganisationInfoPage;
import OR.CreateOrganizationPage;
import OR.HomePage;
import ObjectRepository.CreateNewOrganisationPage;

public class CreateOrganisationTest extends BaseClass1
{
	@Test
	public void CreateOrganisation() throws Throwable
	{

		String ORGNAME = e.readDataFromEF("Sheet1", 1, 2) + j.getRandomNumber();
		String INDUSTRYNAME = e.readDataFromEF("Sheet1", 1, 3);


		HomePage hp = new HomePage(driver);
		hp.clickOnOrganisationLink();

		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.clickOnCreateOrganisationImageLink();

		CreateNewOrganisationPage cnop = new CreateNewOrganisationPage(driver);
		cnop.createNewOrganization(ORGNAME, INDUSTRYNAME);

		CreateOrganisationInfoPage coip = new CreateOrganisationInfoPage(driver);
		String orgHeader = coip.getOrganisationHeaderText();

		System.out.println(orgHeader);
	}
}
