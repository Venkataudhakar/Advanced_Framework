package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPagePractice
{
	public static void main(String[] args)
	{
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("http://localhost:8888/");
		
	/*	driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
	*/
		LoginPage lp = new LoginPage(driver);
		lp.getUserNameEdt().sendKeys("admin");;
		lp.getPasswordEdt().sendKeys("admin");;
		lp.getLoginBtn().click();
/*		
	//Code Optimization
		LoginPage lp1 = new LoginPage(driver);
		lp1.loginToApp(USERNAME, PASSWORD);
*/	
		driver.quit(); 
	}
}
