package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact
{
	public static void main(String[] args) throws Throwable 
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
		
		String LASTNAME = eutil.readDataFromExcel("Contacts", 1, 2)+jUtil.getRandomNumber();
		
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
			
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(contactHeader.contains(LASTNAME))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		wUtil.mouseHoverAction(driver, ele);
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("Sign Out")).click();		
		System.out.println("SignOut successful");
		
		driver.close();
	}
}

	

