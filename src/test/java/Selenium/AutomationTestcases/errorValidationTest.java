package Selenium.AutomationTestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Selenium.AutomationPages.cartPage;
import Selenium.AutomationPages.productcalalogPage;

public class errorValidationTest extends baseClassTest
{
	@Test
	public void loginFailed()
	{
		loginPage.loginApplication("notice21ajay@gmail.com", "Auto1234");
		Assert.assertEquals("Incorrect email or password.", loginPage.getErrorMessage());
	}
	
	@Test
	public void productValidation() throws InterruptedException
	{
		String product = "ADIDAS ORIGINAL";		
		productcalalogPage pp = loginPage.loginApplication("notice2ajay@gmail.com", "Auto1234");		
		pp.addProductCart(product);			
		cartPage cp = pp.goToCartPage();
		boolean match = cp.verifyingCartProduct("ADIDAS ORIGINAL1");		
		Thread.sleep(5000);		
		Assert.assertFalse(match);		
	}
	
}
