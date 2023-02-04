package Selenium.AutomationPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orderPage extends utility
{
	WebDriver d;

	public orderPage(WebDriver d)
	{
		super(d);
		this.d = d;
		PageFactory.initElements(d, this);
	}
	
	@FindBy(xpath = "//tbody/tr[*]/td[2]")
	List<WebElement> orderProducts;
	
	@FindBy(xpath = "//tbody/tr[1]/td[6]")
	WebElement deleteOrderProducts;
	
	//*[@class= 'ng-tns-c4-4 toast-message ng-star-inserted']
	
	@FindBy(xpath= "//div[@aria-label='Orders Deleted Successfully']")
	WebElement deleteOrderConfirmation;	
	
	public List<WebElement> orderProductsList()
	{
		return orderProducts;
	}
	
	public boolean verifyingOrderProduct(String product)
	{	
		System.out.println(orderProductsList().size());
		
		boolean orderProduct = false;
		
		for(int i = 0; i< orderProductsList().size(); i++)
		{
			System.out.println(orderProducts.get(i).getText());
			orderProduct = orderProducts.get(i).getText().equalsIgnoreCase(product);
		}	
		
		return orderProduct;	
	}
	
	public String deleteOrder()
	{
		deleteOrderProducts.click();
		waitForElementVisibility(deleteOrderConfirmation);
		return deleteOrderConfirmation.getText();
	}
	
	
	
	
}