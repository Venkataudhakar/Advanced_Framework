package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario_2
{
	public static void main(String[] args) 
	{
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("abc");
		driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
		
		WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
		
		Select s = new Select(dropdown);
		s.selectByVisibleText("Team Selling");
		
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
