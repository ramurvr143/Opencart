package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginpage extends BasePage
{
	public loginpage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(id ="input-email")
	WebElement emaiaddress;
	@FindBy(id ="input-password")
	WebElement password;
	@FindBy(xpath ="//input[@value='Login']")
	WebElement loginbtun;
	
	public void enteremai(String email) {
		emaiaddress.sendKeys(email);
		
	}
	public void enterpassword(String psw) {
		password.sendKeys(psw);
	}

	public void clicklogin() {
		loginbtun.click();
	}
}
