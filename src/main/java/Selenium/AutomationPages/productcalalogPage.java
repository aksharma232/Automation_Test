package Selenium.AutomationPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productcalalogPage extends utility
{
	WebDriver d;
	
	public productcalalogPage(WebDriver d)
	{
		super(d);
		this.d = d;
		PageFactory.initElements(d, this);
	}

	@FindBy(id = "toast-container")
	WebElement toastmessage;
	
	@FindBy(xpath="//*[@class=\"card-body\"]")
	List<WebElement> products;
	
	public List<WebElement> productslist()
	{
		return products;
	}
	
	public void addProductCart(String productNameToBuy)
	{
		for(int i = 0; i<productslist().size();i++)
		{
			String productname = d.findElements(By.xpath("//*[@class=\"card-body\"]")).get(i).getText();
			String[] a = productname.split("\\$ "); 
			String actualProductName = a[0].trim(); 
			if(actualProductName.equals(productNameToBuy))
			{
				WebElement e = d.findElements(By.xpath("//*[@class=\"card-body\"]")).get(i);
				e.findElement(By.xpath(".//*[@class=\"btn w-10 rounded\"]")).click();
				waitForElementInvisibility(toastmessage);
				
			}
		} 
	}
}
