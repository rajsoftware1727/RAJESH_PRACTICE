package PRACTICE;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.bouncycastle.util.encoders.Base64;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShotDemo {
	
	WebDriver driver;
	
	@BeforeTest
	public void openGoogle()
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.google.com");
	}
	
	@Test
	public void screenshotFile() throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File des=new File(System.getProperty("user.dir")+"//screenshotPics//1.jpg");
		FileUtils.copyFile(src, des);
	}
	
	public void screenshotBase64() throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		String s=ts.getScreenshotAs(OutputType.BASE64);
		byte[] g=Base64.decode(s);
		FileOutputStream fo=new FileOutputStream(System.getProperty("user.dir")+"//screenshotPics//2.jpg");
		fo.write(g);

	}
	
	@AfterTest()
	public void tearDown()
	{
		driver.close();
	}

}
