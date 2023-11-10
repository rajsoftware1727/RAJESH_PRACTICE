package PRACTICE;

import org.testng.annotations.Factory;

public class FactoryDemo {
	
	@Factory
	public Object[] f()
	{
		Object data[]=new Object[2];
		data[0]=new F1();
		data[1]=new F2();
		return data;
	}

}
