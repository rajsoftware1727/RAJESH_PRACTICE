package TEST;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import POM.Login;
import UTILITIES.Base;
import UTILITIES.PropertyFileReader;

public class Login_With_Valid_Credentials extends Base{
	
	@Test
	public void verifyLogin() throws IOException
	{
		Login login=new Login(Base.getDriver());
		login.oneclickLogin(Base.validUname(),Base.validpwd());
		Assert.assertEquals(Base.getDriver().getTitle(),login.validTitle());
		Assert.assertEquals(login.welcomeMsg(),login.validMessage());
		
		 
	}
	
	

}
