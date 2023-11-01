package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import GenericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario_1
{
	public static void main(String[] args) throws Throwable 
	{
	//	System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("http://localhost:8888/");
		WebDriverUtility wutil = new WebDriverUtility();
		wutil.captureScreenshot(driver, "url");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		wutil.captureScreenshot(driver, "login");
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("Sudhakar");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(contactHeader.contains(contactHeader))
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
