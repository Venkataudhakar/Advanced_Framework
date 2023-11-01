package Practice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Senario1WithDDT
{
	public static void main(String[] args) throws Throwable
	{
		//Step 1: Read all the necessary Data		
		/*read data from property file-common data*/		
			FileInputStream pfis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
			Properties pobj = new Properties();
			pobj.load(pfis);
			String BROWSER  = pobj.getProperty("browser");
			String URL      = pobj.getProperty("url");
			String USERNAME = pobj.getProperty("username");
			String PASSWORD = pobj.getProperty("password");
		
		 /*read data from excel-test data*/		
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
			Workbook wb	= WorkbookFactory.create(fis);
			String LASTNAME = wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();
		
		//Step 2: Launch the Browser // Run Time Polymorphism - driver
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
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
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
		
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("Sign Out")).click();		
		System.out.println("SignOut successful");
		
		driver.close();
	}
}
