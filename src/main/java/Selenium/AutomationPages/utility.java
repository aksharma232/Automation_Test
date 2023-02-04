package Selenium.AutomationPages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class utility 
{
	WebDriver d;
	public utility(WebDriver d) 
	{
		this.d = d;
	}
	
	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement goToCartPage;
	
	public cartPage goToCartPage() throws InterruptedException
	{
		//Thread.sleep(5000);
		goToCartPage.click();
		cartPage cp = new cartPage(d);
		return cp;
	}
	
	@FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
	WebElement orderHistory;
	
	public orderPage ordersPage() throws InterruptedException
	{
		
		orderHistory.click();
		orderPage op = new orderPage(d);
		return op;
	}
	
	
	
	public void waitForElementInvisibility(WebElement e)
	{
		WebDriverWait exwait = new WebDriverWait(d, Duration.ofSeconds(10));
		exwait.until(ExpectedConditions.invisibilityOf(e));
	}
	
	public void waitForElementVisibility(WebElement e)
	{
		WebDriverWait exwait = new WebDriverWait(d, Duration.ofSeconds(10));
		exwait.until(ExpectedConditions.visibilityOf(e));
	}
}

