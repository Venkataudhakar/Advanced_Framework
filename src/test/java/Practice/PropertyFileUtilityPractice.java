package Practice;

import GenericUtilities.PropertyFileUtility;

public class PropertyFileUtilityPractice
{
	public static void main(String[] args) throws Throwable
	{
		PropertyFileUtility putil = new PropertyFileUtility();
		String BROWSER = putil.readDataFromPropertyFile("browser");
		String URL = putil.readDataFromPropertyFile("url");
		String USERNAME = putil.readDataFromPropertyFile("username");
		String PASSWORD = putil.readDataFromPropertyFile("password");
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
	}
}
