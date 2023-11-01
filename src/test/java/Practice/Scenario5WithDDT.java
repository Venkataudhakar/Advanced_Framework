package Practice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;
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

public class Scenario5WithDDT
{
	public static void main(String[] args) throws Exception
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		
		String BROWSER  = pobj.getProperty("browser");
		String URL      = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		
		FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		String LASTNAME = wb.getSheet("Organisation").getRow(16).getCell(2).getStringCellValue();
		String ORGSEARCH = wb.getSheet("Organisation").getRow(16).getCell(3).getStringCellValue();
		
		WebDriver driver = null;
		if (BROWSER.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("Edge launched successfully");
		} 
		else if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Edge launched successfully");
		}
		else if (BROWSER.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Edge launched successfully");
		}
		else
		{
			System.out.println("Invalid browser launched");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(URL);
		Thread.sleep(1000);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		String parent = driver.getWindowHandle();	
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
		Set<String> child = driver.getWindowHandles();
		
		for (String b : child) 
		{
			driver.switchTo().window(b);
			System.out.println();
		}
		driver.findElement(By.id("search_txt")).sendKeys(ORGSEARCH);
		driver.findElement(By.name("search")).click();
		driver.switchTo().window(parent);
		
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Sign Out")).click();		
		System.out.println("SignOut successful");
		
		driver.close();
	
	}
}
