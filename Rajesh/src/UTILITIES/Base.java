package UTILITIES;

import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

 
public class Base {
	
	public static WebDriver driver;
	public static Logger logger;
	public static String username;
	public static String pwd;
	
	@BeforeTest
	//@Parameters("browserName")
	public static void openBrowser() throws IOException
	{
		  String browserName=(String)PropertyFileReader.getData("browserName");

		
		if(browserName.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get((String)PropertyFileReader.getData("URL"));
		logger=Logger.getLogger("Rajesh");
		PropertyConfigurator.configure("log4j.properties");
		logger.info("browser opened");
	}
	
	
	@AfterTest
	public static void browserTearDown()
	{
		driver.close();
		logger.info("browser closed");
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public static String validUname() throws IOException
	{
		return username=(String)PropertyFileReader.getData("userName");
	}
	
	public static String validpwd() throws IOException
	{
		return pwd=(String)PropertyFileReader.getData("password");
	}

}
