package Practice;

import GenericUtilities.ExcelFileUtility;

public class ExcelFileUtilityPractice
{
	public static void main(String[] args) throws Throwable
	{
		ExcelFileUtility eutil = new ExcelFileUtility();
		String LASTNAME = eutil.readDataFromExcel("Contacts", 1, 2);
		System.out.println(LASTNAME);
		
		String ORGNAME = eutil.readDataFromExcel("Organisation", 1, 2);
		System.out.println(ORGNAME);
		
		String ASSIGNTO = eutil.readDataFromExcel("Organisation", 1, 3);
		System.out.println(ASSIGNTO);
	}
}
