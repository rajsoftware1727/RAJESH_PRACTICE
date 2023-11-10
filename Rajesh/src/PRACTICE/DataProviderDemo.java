package PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import UTILITIES.DataProvider1;

public class DataProviderDemo {
	
	@Test(dataProvider="raj",dataProviderClass=DataProvider1.class)
	public static void test1(String s[])
	{
		System.out.println(s[0]);
	}

}
