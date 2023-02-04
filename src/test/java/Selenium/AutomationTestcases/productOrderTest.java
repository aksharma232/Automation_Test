package Selenium.AutomationTestcases;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Selenium.AutomationPages.cartPage;
import Selenium.AutomationPages.orderPage;
import Selenium.AutomationPages.paymentPage;
import Selenium.AutomationPages.productcalalogPage;


public class productOrderTest extends baseClassTest
{
	String product = "ADIDAS ORIGINAL";
	orderPage op;
	
	@Test(dataProvider = "orderProductTestData", groups = {"purchase"})
	public void orderproduct(String email,String password, String product) throws InterruptedException, IOException 
	{
		//productcalalogPage pp = loginPage.loginApplication("notice2ajay@gmail.com", "Auto1234");		
		ex_report.createTest("Purchase_Order");
		productcalalogPage pp = loginPage.loginApplication(email, password);
		pp.addProductCart(product);			
		cartPage cp = pp.goToCartPage();		
		Assert.assertTrue(cp.verifyingCartProduct(product));		
		paymentPage paymentPage = cp.checkout();		
		paymentPage.placeOrder("India");		
		Assert.assertTrue(d.findElement(By.xpath("//*[@class=\"hero-primary\"]")).isDisplayed());
		File src = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(".\\screenshot\\fullimage.jpg"));
		ex_report.flush();
	}

	//@Test(dependsOnMethods = {"orderproduct"})
	public void orderConfirmation() throws InterruptedException
	{
		productcalalogPage pp = loginPage.loginApplication("notice2ajay@gmail.com", "Auto1234");
		op = pp.ordersPage();
		Thread.sleep(5000);
		boolean productmatch = op.verifyingOrderProduct(product);
		Assert.assertTrue(productmatch);
	}

//	@Test (dependsOnMethods = {"orderConfirmation"})
	public void deleteOrderProduct() throws InterruptedException
	{
		productcalalogPage pp = loginPage.loginApplication("notice2ajay@gmail.com", "Auto1234");
		Thread.sleep(5000);
		op = pp.ordersPage();
		Assert.assertEquals("Orders Deleted Successfully", op.deleteOrder());
	}
	
	@DataProvider
	public Object[][] orderProductTestData()
	{
		Object[][] data = new Object[2][3];
		data[0][0] = "notice2ajay@gmail.com";
		data[0][1] = "Auto1234";
		data[0][2]= "ADIDAS ORIGINAL";
		
		data[1][0] = "notice2ajay@gmail.com";
		data[1][1] = "Auto1234";
		data[1][2] = "ZARA COAT 3";
		return data;
	}
	
	
}
