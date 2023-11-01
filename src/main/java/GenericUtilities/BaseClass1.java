package GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import OR.HomePage;
import OR.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass1
{
	public PF p = new PF();
	public EF e = new EF();
	public Java j = new Java();
	public WebDriverUtility w = new WebDriverUtility();
	public WebDriver driver = null;

	@BeforeSuite
	public void bsConfig()
	{
		System.out.println("----DB Connection Started------");
	}
	@BeforeClass
	public void bcConfig() throws Throwable
	{
		String BROWSER = p.readDataFromPF("browser");
		String URL = p.readDataFromPF("url");

		if (BROWSER.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("-----Edge browser launched-----");
		} 
		else if (BROWSER.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("-----Chrome browser launched-----");
		}
		else if (BROWSER.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("-----Firefox browser launched-----");
		}
		else 
		{
			System.out.println("-----Invalid browser launched-----");
		}	

		w.maximizeWindow(driver);
		w.waitForPageLoad(driver);

		driver.get(URL);
		System.out.println("----BROWSER launched successfully------");
	}
	@BeforeMethod
	public void bmConfig() throws Throwable
	{
		String USERNAME = p.readDataFromPF("username");
		String PASSWORD = p.readDataFromPF("password");

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("----Login successfully------");
	}
	@AfterMethod
	public void amConfig() throws Throwable
	{
		HomePage hp = new HomePage(driver);
		hp.logOut(driver);
		System.out.println("----Logout Successfully------");
	}
	@AfterClass
	public void acConfig()
	{
		driver.quit();
		System.out.println("----Browser closed------");
	}
	@AfterSuite
	public void asConfig()
	{
		System.out.println("----DB Connection Closed------");
	}
}
