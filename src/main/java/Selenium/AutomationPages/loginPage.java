package Selenium.AutomationPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage extends utility
{
	WebDriver d;

	public loginPage(WebDriver d)
	{
		super(d);
		this.d = d;
		PageFactory.initElements(d, this);
	}

	//WebElement username = d.findElement(By.id("userEmail"));
	// Page Factory
	@FindBy(id="userEmail")
	WebElement username;
	
	@FindBy(id="userPassword")
	WebElement passwd;
	
	@FindBy(id= "login")
	WebElement loginbutton;
	
	@FindBy(xpath = "//div[@aria-label='Incorrect email or password.']")
	WebElement loginError;
	
	@FindBy(xpath = "//div[contains(text(),'Login Successfully')]")
	WebElement loginConfirmationMessage;
	
	@FindBy(xpath = "//div[contains(text(),'*Email is required')]")
	WebElement loginEmailrequired;
	
	@FindBy(xpath = "//div[contains(text(),'*Password is required')]")
	WebElement loginPasswordrequired;
		
	public productcalalogPage loginApplication(String email, String password)
	{
		username.sendKeys(email);
		passwd.sendKeys(password);
		loginbutton.click();
		productcalalogPage pp = new productcalalogPage(d);
		return pp;
	}
	
	public String getErrorMessage()
	{
		waitForElementVisibility(loginError);
		return loginError.getText();
	}

	public String loginConfirmationMessage()
	{
		waitForElementVisibility(loginConfirmationMessage);
		return loginConfirmationMessage.getText();
	}
	
	public String loginpasswordRequired()
	{
		waitForElementVisibility(loginPasswordrequired);
		return loginPasswordrequired.getText();
	}
	
	public String loginEmailRequired()
	{
		waitForElementVisibility(loginPasswordrequired);
		return loginEmailrequired.getText();
	}





}
