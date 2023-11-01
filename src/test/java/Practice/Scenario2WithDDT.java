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
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario2WithDDT
{
	public static void main(String[] args) throws Exception
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		
		FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		String ORGNAME = wb.getSheet("Organisation").getRow(1).getCell(2).getStringCellValue();
		String ASSIGNTO = wb.getSheet("Organisation").getRow(1).getCell(3).getStringCellValue();
		
		WebDriver driver=null;
		if (BROWSER.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("Edge browser launched");
		} 
		else if (BROWSER.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Chrome browser launched");
		}
		else if (BROWSER.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Firefox browser launched");
		}
		else
		{
			System.out.println("Invalid browser launched");
		}
			
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
		
		WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
		
		Select s = new Select(dropdown);
		s.selectByVisibleText(ASSIGNTO);
		
		driver.findElement(By.name("button")).click();
		String orgHeader = driver.findElement(By.className("dvHeaderText")).getText();
		
		if(orgHeader.contains(orgHeader))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		driver.close();
	}
}
	

