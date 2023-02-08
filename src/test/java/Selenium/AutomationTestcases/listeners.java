package Selenium.AutomationTestcases;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class listeners implements ITestListener 
{
	ExtentTest test;
	
	ExtentreportNG extest = new ExtentreportNG();
	
	ExtentReports exreport = extest.extentTestNGReport();
	
	@Override

	public void onTestStart(ITestResult result) {
	
		//System.out.println("Test Cases Started = "+ result.getName());
		test = exreport.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Test Cases Pass = "+ result.getName());
		test.log(Status.PASS, "Test Case PASS");
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		System.out.println("Test Cases Fail = "+ result.getName());
		test.log(Status.FAIL, "Test is FAIL");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		exreport.flush();
		
	}

}
