package TEST;

 import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import UTILITIES.Base;

public class CrossBrowserTesting extends Base {
	
	
	@Test
	public void crossBrowserTesting()
	{
		WebElement t=driver.findElement(By.xpath("(//input[@class='gNO89b'])[2]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeAsyncScript("arguments[0].style.border='3px solid blue'",t);
	}

}
