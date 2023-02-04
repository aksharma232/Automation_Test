package Selenium.AutomationPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cartPage extends utility 
{
	WebDriver d;
		
	public cartPage(WebDriver d) {
		super(d);
		this.d = d;
		PageFactory.initElements(d, this);
	}

	@FindBy(xpath = "//*[@class=\"cart\"]//ul")
	List<WebElement> cartProducts;
	
	public List<WebElement> cartProductsList()
	{
		return cartProducts;
	}
	
	public boolean verifyingCartProduct(String product)
	{	
		boolean cartProduct = false;
		
		for(int i = 0; i<cartProductsList().size();i++)
		{
			cartProduct = cartProductsList().get(i).getText().contains(product);
		}	
		return cartProduct;	
	}
	
	@FindBy(xpath = "//*[@class =\"btn btn-primary\" and text() = \"Checkout\"]")
	WebElement checkOutButton;
	
	public paymentPage checkout()
	{
		checkOutButton.click();
		return new paymentPage(d);
	}
}
