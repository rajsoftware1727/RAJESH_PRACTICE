package PRACTICE;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertionsDemo {
	
	//hard assertions
	WebDriver driver;
	
	@Test
	public void facebook()
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.facebook.com");
		WebElement username=driver.findElement(By.id("email"));
		username.sendKeys("dd",Keys.ENTER);
		
		//hard assertion throw exception immediately
		
		//soft assertion record the exception finally throw all the exceptions when call the assertall method
		
		SoftAssert soft=new SoftAssert();
		/*//verify title
		String expectedTitle="Log in to Facebook";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(expectedTitle,actualTitle,"title mismatched");*/
		
		WebElement t=driver.findElement(By.xpath("//input[@name='email']"));
		
	   //verify border
		String actualBorder=t.getCssValue("border");
		String expectedBorder="1px solid rgb(240, 40, 74)";
		soft.assertEquals(expectedBorder,actualBorder,"border color mismatch");
		
		//verify error message
		
		WebElement t1=driver.findElement(By.xpath("//div[@class='_9ay7']"));
		String actualmsg=t1.getText();
		String expectedmsg="The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
		soft.assertEquals(expectedmsg,actualmsg);
		soft.assertAll();
		
		driver.close();
	}

}
