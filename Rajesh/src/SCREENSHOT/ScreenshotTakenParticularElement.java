package SCREENSHOT;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotTakenParticularElement {
	
	WebDriver driver;
	
	@Test
	public void element() throws IOException
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.google.com");
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File f=ts.getScreenshotAs(OutputType.FILE);
		
		//read the image file from file by imageio
		
		BufferedImage image=ImageIO.read(f);
		
		//find element
		
		WebElement t=driver.findElement(By.xpath("//img[@class='lnXdpd']"));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='5px solid aqua'",t);
		System.out.println("border ok");
		
		//get element location
		
		Point location=t.getLocation();
		
		int width=t.getSize().getWidth();
		int height=t.getSize().getHeight();
		
		//get subimage from full image
		
		BufferedImage subimage=image.getSubimage(location.getX(),location.getY(), width, height);
		
		//write the image into file
		
		ImageIO.write(subimage,"png",f);
		FileUtils.copyFile(f,new File("D:\\JAVA PROJECTS\\Rajesh\\SCREENSHOT\\5.JPG"));
		driver.close();
		System.out.println("success");
		
		
		
		
		
		
	}

}
