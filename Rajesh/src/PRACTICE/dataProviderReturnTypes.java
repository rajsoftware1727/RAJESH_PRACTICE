package PRACTICE;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderReturnTypes {
	
	/*@Test(dataProvider="tt")
	public void test1(String s)
	{
		System.out.println(s);
	}
	
	@DataProvider(name="tt")
	public Iterator<String> data()
	{
		List<String> a=new ArrayList<String>();
		a.add("r1");a.add("r2");a.add("r3");
		return a.iterator();
	}*/
	
	
	/*@Test(dataProvider="tt")
	public void test1(String s[])
	{
		System.out.println(s[2]);
	}
	
	@DataProvider(name="tt")
	public Iterator<String[]> data()
	{
		List<String[]> a=new ArrayList<String[]>();
		String s1[]= {"g1","g2","g3"};
		String s2[]= {"e1","e2","e3"};
		a.add(s1);a.add(s2);

 		return a.iterator();
	}*/
	
	/*@Test(dataProvider="tt")
	public void test1(String s[][])
	{
		System.out.println(s[0][1]+s[1][1]);
	}
	
	@DataProvider(name="tt")
	public Iterator<String[][]> data()
	{
		List<String[][]> a=new ArrayList<String[][]>();
		String s1[][]= {{"g1","g2"},{"g3","g4"}};
		String s2[][]= {{"e1","e2"},{"e3","e4"}};
		a.add(s1);a.add(s2);

 		return a.iterator();
	}
	
	/*@Test(dataProvider="hh")
	public void enterNames1(String s[])
	{
		System.out.println(s[1]);
	}
	
	@DataProvider(name="hh")
	public String[][] data1()
	{
		String[][] a= {{"raj","aki"},{"thrishiv","nishavu"}};
		return a;

     }*/
	
	/*@Test(dataProvider="gg")
	public void test1(String s[])
	{
		System.out.println(s[0]+s[1]);
	}
	
	@DataProvider(name="gg")
	public String[][] data()
	{
		String data[][]= {{"raj","aki"},{"thrishiv","nishavu"}};
		return data;
		
	}*/
	
	@Test(dataProvider="gg")
	public void test2(String s[][])
	{
		System.out.println(s[0][0]+s[0][1]);
	}
	
	@DataProvider(name="gg")
	public Iterator<String[][]> data2()
	{
		 List<String[][]> data=new ArrayList<String[][]>();
		 String d[][]= {{"raj","aki"},{"aa","bb"}};
		 String e[][]= {{"thrishiv","nishavu"},{"cc","dd"}};
		 data.add(d);
		 data.add(e);
		 return data.iterator();
		
	}

}
