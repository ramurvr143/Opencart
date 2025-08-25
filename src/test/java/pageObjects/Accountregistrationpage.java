package pageObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Accountregistrationpage extends BasePage {
	public Accountregistrationpage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy (xpath ="//input[@id='input-firstname']")
	WebElement firstname;
	@FindBy(xpath ="//input[@id='input-lastname']")
	WebElement lastname;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email;
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement telephone;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement confirmpassword;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement checkagree;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continuebutton;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgconfirmationl;
	
	public void setfirstname(String fname) 
	{
		firstname.sendKeys(fname);
		
	}
	public void setlastname(String lname) 
	{
	    lastname.sendKeys(lname);
		
	}
	public void setemail(String useremail) 
	{
		email.sendKeys(useremail);
		
	}
	public void settelephone(String phone) 
	{
		telephone.sendKeys(phone);
		
	}
	public void setpassword(String psw) 
	{
		password.sendKeys(psw);
		
	}
	public void setconfirmpassword(String cpsw) 
	{
		confirmpassword.sendKeys(cpsw);
		
	}
	public void setprivacy()
	{
		checkagree.click();
	}
	
	public void clickcontinue()
	{
		continuebutton.click();
	}
	public String getmessage()
	{
		try {
			return(msgconfirmationl.getText());
		} catch (Exception e) {
			return(e.getMessage());
		}
	}
}
