package SCREENSHOT;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenshotByAshotDemo {
	
	public static void main(String args[]) throws IOException
	{
		WebDriver driver;
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.get("http://www.google.com");
		AShot s=new AShot();
		Screenshot d=s.shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver); //it take screen shot
		File f=new File("D:\\JAVA PROJECTS\\Rajesh\\SCREENSHOT\\6.jpg");
		ImageIO.write(d.getImage(),"jpg",f);
		driver.close();
		System.out.println("success");
	}

}
