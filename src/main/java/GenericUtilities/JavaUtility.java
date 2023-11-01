package GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 * This class consists of Generic methods related to Java
 * @author user
 *
 */
public class JavaUtility
{
/**
 * This method will generate the Random number for every run and return it to the caller
 * @return
 */
	public int getRandomNumber()
	{
		Random ran = new Random();
		int r = ran.nextInt(10000);
		return r;
	}
/**
 * This method will capture the current system date in the required format
 * @return
 */
	public String getSystemDate()
	{
		Date d = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String date = formatter.format(d);
		return date;
	}
}
