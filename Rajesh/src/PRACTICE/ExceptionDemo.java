package PRACTICE;

import org.testng.annotations.Test;

public class ExceptionDemo {
	
	@Test
	public static void test1()
	{
		int a=5/0;
		System.out.println(a);
	}
	

	@Test(expectedExceptions=Exception.class)
	public static void test2()
	{
		int a=5/0;
		System.out.println(a);
	}

}
