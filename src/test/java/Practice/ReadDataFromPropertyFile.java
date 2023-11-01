package Practice;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadDataFromPropertyFile
{
	public static void main(String[] args) throws Throwable
	{
	//step 1: Open the document in Java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	//step 1: Create Object of Properties for java.util package
		Properties pobj = new Properties();
	//step 1: Load the File Input Stream into Properties
		pobj.load(fis);
	//step 1: Provide the Key & Read the Value
		String BROWSER  = pobj.getProperty("browser");
		String URL      = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
	}
}
