package Selenium.AutomationTestcases;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class listeners implements ITestListener 
{
	ExtentTest test;
	ExtentreportNG extest;
	@Override
	public void onTestStart(ITestResult result) {
	
		 extest = new ExtentreportNG();
		test = extest.extentTestNGReport().createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//System.out.println("Test case is pass Testcase Name - "+ result.getName());
		test.log(Status.PASS, "Test PASS");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test is FAIL");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extest.extentTestNGReport().flush();
		
	}

}
