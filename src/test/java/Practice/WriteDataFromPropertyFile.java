package Practice;

import java.io.FileOutputStream;
import java.util.Properties;

public class WriteDataFromPropertyFile
{
	public static void main(String[] args) throws Throwable
	{
		Properties pwrite = new Properties();
		pwrite.setProperty("username", "admin");
		pwrite.setProperty("password", "admin");
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\WriteData.properties");
		pwrite.store(fos, "This is My File");
		System.out.println("File Created with New Data");
	}
}
