package Selenium.AutomationTestcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Selenium.AutomationPages.loginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class productOrder_orig {
	@Test
	public void orderproduct() throws InterruptedException, IOException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		WebDriver d = new ChromeDriver(option);
		loginPage lp = new loginPage(d);
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("https://rahulshettyacademy.com/client");
		//d.findElement(By.id("userEmail")).sendKeys("notice2ajay@gmail.com");
		//d.findElement(By.id("userPassword")).sendKeys("Auto1234");
		//d.findElement(By.id("login")).click();

		List<WebElement> allproduct = d.findElements(By.xpath("//*[@class=\"card-body\"]"));

		System.out.println(allproduct.size());

		//String[] product = {"IPHONE 13 PRO", "ZARA COAT 3"};

		String product = "IPHONE 13 PRO";

		for(int i = 0; i<allproduct.size();i++)

		{
			String productname = d.findElements(By.xpath("//*[@class=\"card-body\"]")).get(i).getText();

			String[] a = productname.split("\\$ "); 

			String butproduct = a[0].trim(); 

			if(butproduct.equals(product))
			{
				WebElement e = d.findElements(By.xpath("//*[@class=\"card-body\"]")).get(i);
				e.findElement(By.xpath(".//*[@class=\"btn w-10 rounded\"]")).click();
			}
			//continue;
		} 

		WebDriverWait exwait = new WebDriverWait(d, Duration.ofSeconds(10));
		
		//exwait.until(ExpectedConditions.invisibilityOf(d.findElement(By.id("toast-container"))));
		
		exwait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("toast-container")));
		
		d.findElement(By.xpath("//*[@routerlink=\"/dashboard/cart\"]")).click();

		List<WebElement> cartproducts = d.findElements(By.xpath("//*[@class=\"cart\"]//ul"));

		for(WebElement productverify :  cartproducts)
		{
			String cartproduct = productverify.getText();
			
			if(cartproduct.contentEquals("IHPONE"));
			{
				System.out.println("Yes1");
				
				d.findElement(By.xpath("//*[@class = \"btn btn-primary\" and text() = \"Checkout\"]")).click();
				
				d.findElement(By.xpath("//*[@placeholder = \"Select Country\"]")).click();
				
				d.findElement(By.xpath("//*[@placeholder = \"Select Country\"]")).sendKeys("India");
				
				d.findElement(By.xpath("(//*[@class = \"fa fa-search\"])[2]")).click();
				
				d.findElement(By.xpath("//a[@class = \"btnn action__submit ng-star-inserted\"]")).click();
				
				Assert.assertTrue(d.findElement(By.xpath("//*[@class=\"hero-primary\"]")).isDisplayed());
				
				File src = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
				
				FileUtils.copyFile(src, new File(".\\screenshot\\fullimage.jpg"));
			}
		} 

	}
}

