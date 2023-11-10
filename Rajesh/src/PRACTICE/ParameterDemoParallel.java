package PRACTICE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.*;

 
import io.github.bonigarcia.wdm.WebDriverManager;

public class ParameterDemoParallel {
	
	WebDriver driver;
	
 	@BeforeTest
	@Parameters("bname")
    public void openBrowser(String browserName)
	  {
 		if(browserName.equalsIgnoreCase("Edge"))
 		{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
 	}
 		else if(browserName.equalsIgnoreCase("Fire"))
 		{
 			WebDriverManager.firefoxdriver().setup();
 			driver=new FirefoxDriver();
 		}
 		driver.manage().window().maximize();
	  }
	
	@Test
	public void google()
	{
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		System.out.println(Thread.currentThread().getId());
	}
	
	@Test
	public void youtube()
	{
		driver.get("http://www.youtube.com");
		System.out.println(driver.getTitle());
		System.out.println(Thread.currentThread().getId());

	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
