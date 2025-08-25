package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends BasePage
{
	
	public Homepage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement linkmyaccount;
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement registerlink;
	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement login;
	public void clickaccount() {
		linkmyaccount.click();
	}
	public void clickregister() {
		registerlink.click();
	}
	public void clicklogin() {
		login.click();
	}
}
