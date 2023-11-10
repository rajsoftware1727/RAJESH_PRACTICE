package POM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import UTILITIES.PropertyFileReader;

public class Login {
	
	WebDriver driver1;
	//declaring the webElements By POM model
	
	@FindBy(how=How.NAME,using="uid")
	private WebElement userName;
	@FindBy(how=How.NAME,using="password")
	private WebElement password;
	@FindBy(name="btnLogin")
	private WebElement loginButton;
	@FindBy(xpath="//marquee[@class='heading3']")
	private WebElement welcomeMessage;
	
	//initializing the WebElements by constructor
	
	public Login(WebDriver ldriver)     //constructor
	{
		this.driver1=ldriver;
		PageFactory.initElements(ldriver,this);
	}
	
	
	//declaring methods
	
	public WebElement userName()
	{
		return userName;
	}
	public WebElement password()
	{
		return password;
	}
	public void clickLogin()
	{
		loginButton.click();
	}
	public String welcomeMsg()
	{
		return welcomeMessage.getText();
	}
	
	public void oneclickLogin(String uname,String pwd)
	{
		userName.sendKeys(uname);
		password.sendKeys(pwd);
		loginButton.click();
	}
	
	public String validMessage() throws IOException
	{
		return PropertyFileReader.getData("validMessage").toString();
	}
	
	public String validTitle() throws IOException
	{
		return PropertyFileReader.getData("validTitle").toString();

	}
	
	
	

}
