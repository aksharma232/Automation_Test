package Selenium.AutomationTestcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentreportNG 
{

	public ExtentReports extentTestNGReport()
	{
		String path = System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setDocumentTitle("Automation_Test_Result");
		report.config().setReportName("Automation Practice");
		
		ExtentReports ex_reports = new ExtentReports();
		ex_reports.attachReporter(report);
		ex_reports.setSystemInfo("TestName", "Ajay Sharma");
		return ex_reports;
		
	}
}
