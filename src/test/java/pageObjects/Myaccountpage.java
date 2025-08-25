package pageObjects;

import java.security.PublicKey;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myaccountpage extends BasePage
{
	public  Myaccountpage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement heading;
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']") 
	WebElement logout;
	
	public boolean accountpageopen() 
	{
		try 
		{
			return (heading.isDisplayed());
		} 
		catch (Exception e) 
		{
			return false;
		}
		
	}
	
	public void clicklogout() 
	{
		logout.click();
	}
	
	
	
	
	

}
