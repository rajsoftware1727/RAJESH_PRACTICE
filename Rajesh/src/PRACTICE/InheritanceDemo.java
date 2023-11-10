package PRACTICE;

public class InheritanceDemo {
	
	public static void main(String args[])
	{
		B b=new B();
		
		
		
	}

}
class A
{
	A()
	{
		System.out.println("am a");
	}
	public void speed()
	{
		System.out.println("speed1");
	}
}
class B extends A
{
	/*public void speed()
	{
		System.out.println("speed2");
		super.speed();
	}*/
	
	B()
	{
		System.out.println("am b");
	}
	
	
	
}
