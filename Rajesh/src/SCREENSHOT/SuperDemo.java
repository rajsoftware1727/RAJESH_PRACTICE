package SCREENSHOT;

public class SuperDemo {
	
	public void bark()
	{
		System.out.println("barking 1");
	}
	SuperDemo()
	{
		System.out.println("am parent class constructor called implicitly");
	}

}
 class SuperDemo1 extends SuperDemo
{
	 
	 public void bark()
		{
		 
			System.out.println("barking 2");
		}
}
  class Test
{
	public static void main(String args[])
	{
		SuperDemo1 s=new SuperDemo1();
		
	}
}