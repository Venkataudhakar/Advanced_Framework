package Practice;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario_5
{
	public static void main(String[] args) throws Throwable
	{
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://localhost:8888/");
		Thread.sleep(1000);
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		String parent = driver.getWindowHandle();	
		driver.findElement(By.name("lastname")).sendKeys("Sudhakar");
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
		Set<String> child = driver.getWindowHandles();
		
		for (String b : child) 
		{
			driver.switchTo().window(b);
			System.out.println();
		}
		driver.findElement(By.id("search_txt")).sendKeys("xyz");
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
