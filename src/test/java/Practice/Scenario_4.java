package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario_4 
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
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys("abc123431");
		WebElement dropDown = driver.findElement(By.name("industry"));
		
		Select s = new Select(dropDown);
		s.selectByValue("Energy");
		
		WebElement type = driver.findElement(By.name("accounttype"));
		Select s1 = new Select(type);
		s1.selectByValue("Competitor");
		
		driver.findElement(By.name("button")).click();
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (orgHeader.contains(orgHeader))
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
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Sign Out")).click();		
		System.out.println("SignOut successful");
		
		driver.close();
	}
}

