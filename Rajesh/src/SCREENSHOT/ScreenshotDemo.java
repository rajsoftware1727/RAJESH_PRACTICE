package SCREENSHOT;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.bouncycastle.util.encoders.Base64;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotDemo {
	
	WebDriver driver;
	
	@Test(priority=0)
	public void openGoogle()
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.google.com");
	}
	
	@Test(priority=1)
	public void screenshotFile() throws IOException
	{
		 
		
		//type cast the driver into takescreenshot interface
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		//invoke getscreen shot method
		
		File f=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f,new File("D:\\JAVA PROJECTS\\Rajesh\\SCREENSHOT\\2.JPG"));
 		
	}
	
	@Test(priority=2)
	public void screenshotBytes() throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		byte data[]=ts.getScreenshotAs(OutputType.BYTES);
		FileOutputStream fo=new FileOutputStream("D:\\JAVA PROJECTS\\Rajesh\\SCREENSHOT\\3.JPG");
		fo.write(data);
		
	}
	
	@Test(priority=3)
	public void screenshotString() throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		String data=ts.getScreenshotAs(OutputType.BASE64);
		byte data1[]=Base64.decode(data);
		FileOutputStream fo=new FileOutputStream("D:\\JAVA PROJECTS\\Rajesh\\SCREENSHOT\\4.JPG");
		fo.write(data1);
		driver.close();
		
	}

}
