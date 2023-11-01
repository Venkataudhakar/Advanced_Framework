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
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario3WithDDT 
{
	public static void main(String[] args) throws Throwable
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
		String ORGNAME = wb.getSheet("Organisation").getRow(5).getCell(2).getStringCellValue();
		String INDUSTRY = wb.getSheet("Organisation").getRow(5).getCell(3).getStringCellValue();
		
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
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		WebElement dropDown = driver.findElement(By.name("industry"));
		
		Select s = new Select(dropDown);
		s.selectByValue(INDUSTRY);
		
		driver.findElement(By.name("button")).click();
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (orgHeader.contains(ORGNAME))
		{
			System.out.println(orgHeader);
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
