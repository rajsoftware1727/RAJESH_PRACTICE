package PRACTICE;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsDemo {
	
	WebDriver driver;
	
	@Test
	public void caps()
	{
		WebDriverManager.edgedriver().setup();;
		driver=new EdgeDriver();
		driver.get("http://www.google.com");
		
		WebElement t=driver.findElement(By.className("gLFyf"));
		Actions c=new Actions(driver);
		/*c.keyDown(t,Keys.SHIFT);
		c.sendKeys("raj");
		c.keyUp(Keys.SHIFT);*/
		c.keyDown(t,Keys.SHIFT).sendKeys("raj").keyUp(Keys.SHIFT);
		Action g=c.build();
		g.perform();
		 
		
	}

}
