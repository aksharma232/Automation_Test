package Selenium.AutomationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class paymentPage extends utility {

	WebDriver d;
	public paymentPage(WebDriver d) 
	{
		super(d);
		this.d = d;
		PageFactory.initElements(d, this);
	}
	
	@FindBy(xpath = "//*[@placeholder = \"Select Country\"]")
	WebElement selectCountry;

	
	@FindBy(xpath = "(//*[@class =\"fa fa-search\"])[2]")
	WebElement countryName;
	
	@FindBy(xpath = "//a[@class = \"btnn action__submit ng-star-inserted\"]")
	WebElement placeOrder;
		
	public void placeOrder(String country) throws InterruptedException
	{
		selectCountry.click();
		selectCountry.sendKeys(country);
		countryName.click();
		placeOrder.click();
	}

}
