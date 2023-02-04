package Selenium.AutomationTestcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class login_logout_Test extends baseClassTest
{
	@Test (dataProvider = "validlogindata")
	public void loginwithValidTest(String email,String password) throws IOException
	{
		//loginPage.loginApplication("notice2ajay@gmail.com", "Auto1234");
		loginPage.loginApplication(email, password);
		Assert.assertEquals(loginPage.loginConfirmationMessage(), "Login Successfully");
	}
	
	@Test (dataProvider = "invalidvalidlogindata")
	public void loginwithInvalidDataTest(String email, String password) throws IOException
	{
		//loginPage.loginApplication("notice21ajay@gmail.com", "Auto1234");
		loginPage.loginApplication(email, password);
		Assert.assertEquals(loginPage.getErrorMessage(), "Incorrect email or password.");
	}
	/*
	public void loginonlyPasswrdEntered() throws IOException
	{
		loginPage.loginApplication("", "Auto1234");
		Assert.assertEquals(loginPage.loginEmailRequired(), "*Email is required");
	}
	
	@Test
	public void loginonlyUserNameEntered() throws IOException
	{
		loginPage.loginApplication("notice21ajay@gmail.com", "");
		Assert.assertEquals(loginPage.loginpasswordRequired(), "*Password is required");
	}
	
	@Test
	public void loginwithoutData() throws IOException
	{
		loginPage.loginApplication("", "");
		Assert.assertEquals(loginPage.loginEmailRequired(), "*Email is required");
		Assert.assertEquals(loginPage.loginpasswordRequired(), "*Password is required");
	}
*/
	@DataProvider
	public Object[][] validlogindata()
	{
		Object[][] data = new Object[2][2];
		data[0][0] = "notice2ajay@gmail.com";
		data[0][1] = "Auto1234";
		
		data[1][0]= "notice2ajay@gmail.com";
		data[1][1]= "Auto1234";
		return data;
	}
	@DataProvider
	public Object[][] invalidvalidlogindata()
	{
		Object[][] data = new Object[2][2];
		data[0][0] = "not2ice2ajay@gmail.com";
		data[0][1] = "Auto1234";
		
		data[1][0]= "notic2e2ajay@gmail.com";
		data[1][1]= "Auto1234";
		return data;
	}
}
