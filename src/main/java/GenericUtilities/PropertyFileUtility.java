package GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class will consist of Generic methods to read the data from property file
 * @author user
 *
 */
public class PropertyFileUtility
{
/**
 * This method will read the data from Property File and return the value to the caller
 * @param key
 * @return
 * @throws Throwable
 */
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj =new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	}
}
