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

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public WebDriver driver =null;
	
	//Using in Listener
	public static WebDriver sdriver;

	@BeforeSuite
	//@BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void bsConfig()
	{
		System.out.println("-----DB Connection Successful-----");
	}
	
	@BeforeClass
	//@Parameters("browser")
	//@BeforeTest
	//@BeforeClass(alwaysRun = true)
	public void bcConfig() throws Throwable
	{
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");

		if (BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER + "---- launched ----");
		} else if (BROWSER.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER + "---- launched ----");
		} else if (BROWSER.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println(BROWSER + "---- launched ----");
		} else {
			System.out.println("Invalid Browser Name");
		}

		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		
		sdriver=driver;
		
		//Used in Listener
		driver.get(URL);
	}
	@BeforeMethod
	//@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws Throwable
		{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("---- Login Successful ----");
	}
	@AfterMethod
	//@AfterMethod(alwaysRun = true)
	public void amConfig() throws Throwable
	{
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		
		System.out.println("---- Logout Successful ----");
	}
	@AfterClass
	//@AfterTest
	//@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		System.out.println("---- Browser Closed ----");
	}
	@AfterSuite
	//@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("-----DB Connection Closed-----");
	}
}
