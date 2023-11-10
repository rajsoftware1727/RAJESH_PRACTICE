package UTILITIES;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {
	
	public static String path;
	public static String sheetName;
	public static String data[][];
	@DataProvider(name="raj")
	public static String[][] testData() throws IOException
	{
		path=System.getProperty("user.dir")+"/student.xlsx";
		
		sheetName="data100";
		int totalrows=ExcelData.totalRows(sheetName, path);
		int totalColumns=ExcelData.totalColumns(sheetName, path);
		data=new String[totalrows-1][totalColumns];
		for(int row=1;row<totalrows;row++)
		{
			for(int column=0;column<totalColumns;column++)
			{
				data[row-1][column]=(String)ExcelData.getcellData(path, sheetName, row, column);
			}
			  
		}
		return data;
		
		/*for(String g[]:data)
		{
			for(String h:g)
			{
				System.out.print(h+" ");
			}
			System.out.println();
		}*/
	}

}
