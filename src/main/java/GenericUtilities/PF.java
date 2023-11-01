package GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PF
{
	public String readDataFromPF(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CD.properties");
		Properties p = new Properties();
		p.load(fis);
		
		 String value = p.getProperty(key);
		 return value;
	}
}
