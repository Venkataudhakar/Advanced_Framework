package GenericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class consist of implementation of ITestListener interface of TestNG
 * @author user
 *
 */
public class ListenerImplementationClass implements ITestListener
{

	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result)
	{
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"----Test script execution started-----");
		
		//Create test script - Recognises each @Test
		test = report.createTest(testScriptName);
	}

	public void onTestSuccess(ITestResult result)
	{
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"----PASSED-----");
		
		//Log for success
		test.log(Status.PASS, testScriptName + "----PASSED-----");
	}

	public void onTestFailure(ITestResult result)
	{
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"----FAILED-----");
		
		//Exception for failure
		System.out.println(result.getThrowable());
		
		//Log for Failure
		test.log(Status.FAIL, testScriptName + "----FAILED-----");
		test.log(Status.INFO, result.getThrowable());
		
		//Screenshot
		String screenShotName = testScriptName + new JavaUtility().getSystemDate();
		WebDriverUtility w = new WebDriverUtility();
		try {
			w.captureScreenshot(BaseClass.sdriver, screenShotName);
			test.addScreenCaptureFromPath(screenShotName);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult result)
	{
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"----SKIPPED-----");
		
		//Exception for skipping
		System.out.println(result.getThrowable());
		
		//Log for Skip
		test.log(Status.SKIP, testScriptName + "----SKIPPED-----");
		test.log(Status.INFO, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
	}

	public void onTestFailedWithTimeout(ITestResult result)
	{
		
	}

	public void onStart(ITestContext context)
	{
		System.out.println("----Suite execution started-----");
		
		//Basic Report Configuration//Report-10-18-2023-11-11-02.html
		ExtentSparkReporter html = new ExtentSparkReporter(".\\Extent Reports\\Report-"+new JavaUtility().getSystemDate()+".html");
		html.config().setTheme(Theme.DARK);
		html.config().setDocumentTitle("Execution Report");
		html.config().setReportName("vTiger Execution Report");
		
		report = new ExtentReports();
		report.attachReporter(html);
		report.setSystemInfo("Basoc Browser", "Edge");
		report.setSystemInfo("Basoc Paltform", "Windows");
		report.setSystemInfo("Basoc Environment", "Testing");
		report.setSystemInfo("Reporter Name", "Venkat");
		
	}

	public void onFinish(ITestContext context)
	{
		System.out.println("----Suite execution started-----");
		
		//Report Generation
		report.flush();
	}
}
