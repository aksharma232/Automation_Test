package Selenium.AutomationTestcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Selenium.AutomationPages.loginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass 
{
	public WebDriver d;
	loginPage loginPage;
	ExtentSparkReporter report;
	ExtentReports ex_report;
	
	
	public WebDriver initalizeBrowser() throws IOException
	{
		Properties prop = new Properties();
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\java\\Selenium\\Resources\\Global.Properties");
		
		prop.load(fis);
		
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
			d = new ChromeDriver(option);
			d.get(prop.getProperty("url"));
		}
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return d;
	}

	@BeforeMethod (alwaysRun = true)
	public loginPage lauchApplication() throws IOException
	{
	
		d = initalizeBrowser();
		loginPage = new loginPage(d);
		return loginPage;
	}
	
	/* 
	public void extentReport()
	{
		
		String path = System.getProperty("user.dir")+"\\report\\index.html";
		report = new ExtentSparkReporter(path);
		report.config().setDocumentTitle("Automation Test Result");
		ex_report = new ExtentReports();
		ex_report.attachReporter(report);
		ex_report.setSystemInfo("Tester Name", "Ajay Sharma");
		
	}
	*/
	@AfterMethod  (alwaysRun = true)
	public void tearDown()
	{
		d.close();
	}
	
}
