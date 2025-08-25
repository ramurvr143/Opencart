package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;


public class Baseclass {
	public static WebDriver driver;
	public Logger logger;
	public Properties p;

	
	@BeforeClass
	@Parameters({"os","browse"})
	public void setup(String os , String browse) throws IOException
	{
		FileReader filep = new FileReader("./src/test/resources/config.properties");
		p = new Properties();
		p.load(filep);
		logger = LogManager.getLogger(this.getClass());
		switch (browse.toLowerCase()) {
		case "chrome":driver = new ChromeDriver();break;
		case "edge":driver = new EdgeDriver();break;
		case "firefox":driver = new FirefoxDriver();break;

		default:
			System.out.println("invalidbrowser");
			return;//it will stop the execution code below it
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appurl"));
		driver.manage().window().maximize();
	}
	@AfterClass
	public void teardown()
	{
		driver.quit();
		
	}
	
	public String randomstring()
	{
		String genstring = RandomStringUtils.randomAlphabetic(5);
		return genstring;
	}
	public String randomnumeric() 
	{
		String number =RandomStringUtils.randomNumeric(10);
		return number;
	}
	public String mixedstring() 
	{
		String genString =RandomStringUtils.randomAlphabetic(3);
		String number = RandomStringUtils.randomNumeric(3);
		return(genString+"@"+number);
	}

	public String captureScreen(String tname) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
	
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);

	return targetFilePath;
	 }


}
