package PRACTICE;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class screenshotParticularElement {
	
	WebDriver driver;
	
	@Test
	public void take() throws IOException
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.get("http://www.google.com");
		
 		WebElement t=driver.findElement(By.xpath("//a[text()='Gmail']"));
 		
 		/*Point location=t.getLocation();
 		int height=t.getSize().getHeight();
 		int width=t.getSize().getWidth();
 		
 		TakesScreenshot ts=(TakesScreenshot)driver;
 		File f=ts.getScreenshotAs(OutputType.FILE);
 		BufferedImage image=ImageIO.read(f);
 		BufferedImage g=image.getSubimage(location.getX(),location.getY(), width, height);
 		ImageIO.write(g,"jpg",f);
 		FileUtils.copyFile(f,new File("D:\\image\\1.jpg"));*/
 		
 		AShot shot=new AShot();
 		Screenshot s=shot.takeScreenshot(driver, t);
 		BufferedImage g=s.getImage();
 		ImageIO.write(g,"png",new File("D:\\image\\1.png"));
 		
 		/*File src=t.getScreenshotAs(OutputType.FILE);
 		FileUtils.copyFile(src,new File("D:\\image\\1.jpg"));*/
 		
 		
 		 
 		
 		driver.close();
 		
 		

        
 		
	}

}
