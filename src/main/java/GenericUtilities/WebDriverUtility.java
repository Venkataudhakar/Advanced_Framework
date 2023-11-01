package GenericUtilities;

import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * This class contains the Generic methods related to web driver actions
 * @author user
 *
 */
public class WebDriverUtility
{
/**
 * This method will maximize the window
 * @param driver
 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
/**
* This method will minimize the window
* @param driver
*/
/*
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
*/
	
/**
 * This method will wait for the page load
 * @param driver
 */
	public void waitForPageLoad(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
/**
 * This method will wait for the particular element	to be visible in the DOM
 * @param driver
 * @param element
 */
	public void waitForElementToBeVisble(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
/**
* This method will wait for the particular element	to be clickable 
* @param driver
* @param element
*/
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
		{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}	
/**
 * This method will handle drop down by Index
 * @param element
 * @param index
 */
	public void handleDropdown(WebElement element, int index)
	{
		Select s = new Select(element);
		s.selectByIndex(0);
	}
/**
* This method will handle drop down by value
* @param element
* @param index
*/
	public void handleDropdown(WebElement element, String value)
		{
			Select s = new Select(element);
			s.selectByValue(value);
		}
/**
* This method will handle drop down by text
* @param element
* @param index
*/
	public void handleDropdown(String text, WebElement element)
		{
			Select s = new Select(element);
			s.selectByVisibleText(text);
		}
/**
 * This method will perform mouseHover action
 * @param driver
 * @param element
 */
	public void mouseHoverAction(WebDriver driver, WebElement element)
	{
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
	}
/**
 * This method will move the cursor based on the Offset and click on Web page
 * @param driver
 */
	public void moveAndCLick(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveByOffset(10, 10).click().perform();
	}
/**
 * This method will perform right click	
 * @param driver
 */
	public void rightClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
/**
 * This method will perform the double click	
 * @param driver
 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
/**
 * This method will perform the drag and drop operation	
 * @param driver
 * @param srcEle
 * @param destEle
 */
	public void dragAndDropAction(WebDriver driver, WebElement srcEle, WebElement destEle)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(srcEle, destEle).perform();
	}
/**
 * This method will handle the frame by Index
 * @param driver
 * @param index
 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
/**
 * This method will handle the frame by Name or ID	
 * @param driver
 * @param nameOrId
 */
	public void switchToFrame(WebDriver driver, String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
/**
* This method will handle the frame by Web Element
* @param driver
* @param nameOrId
*/
	public void switchToFrame(WebDriver driver, WebElement element)
		{
			driver.switchTo().frame(element);
		}
/**
 * This method will scroll down by 500 units	
 * @param driver
 */
	public void scrollDownAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-500);", "");
	}
/**
* This method will scroll up by 500 units	
* @param driver
*/
	public void scrollUpAction(WebDriver driver)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500);", "");
		}
/**
 * This method will accept the alert pop up	
 * @param driver
 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
/**
* This method will cancel the alert pop up	
* @param driver
*/
	public void cancelAlert(WebDriver driver)
		{
			driver.switchTo().alert().dismiss();
		}
/**
* This method will fetch the alert text and return to the caller	
* @param driver
 * @return 
*/
		public String getAlertText(WebDriver driver)
		{
			return driver.switchTo().alert().getText();
		}
/**
 * This method will capture the screen shot and return to the destination path		
 * @param driver
 * @param screenshotName
 * @throws Throwable
 */
		public void captureScreenshot(WebDriver driver, String screenshotName) throws Throwable
		{
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);//temporary location
			File dest = new File(".\\Screenshots\\"+screenshotName+".png");
													//Scenario_1.png
			FileUtils.copyFile(src, dest);
			dest.getAbsolutePath();//used for extent report
		}
		
		public void switchToWindow(WebDriver driver, String PartialWinTitle)
		{
			//Step 1: get all the window IDs
			Set<String> allWinIds = driver.getWindowHandles();
			
			//Step 2: navigate thru each window
			for (String winID : allWinIds)
			{
				//Step 3: switch to each window and capture the title
				String actTitle = driver.switchTo().window(winID).getTitle();
				
				//Step 4: compare the act title with expected partial Title
				if(actTitle.contains(PartialWinTitle))
				{
					break;
				}
			}
		}
}

