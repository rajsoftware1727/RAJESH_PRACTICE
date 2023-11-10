package PRACTICE;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data {
	
	
	@Test(dataProvider="tt")
	public void test(String name,String age)
	{
		System.out.println("my name is "+name+" my age is "+age);
	}
	
	@DataProvider(name="tt")
	public Object data() throws IOException
	{
		String data[][]=null;
		String path="C:\\Users\\AKILA RAJESH\\OneDrive\\Desktop\\NAME AND AGE.xlsx";
		FileInputStream fi=new FileInputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook(fi);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int totalRows=sheet.getPhysicalNumberOfRows();
		int totalcolumns=sheet.getRow(0).getPhysicalNumberOfCells();
		 
		data=new String[totalRows-2][totalcolumns];
		for(int row=2;row<totalRows;row++)
		{
			XSSFRow currentRow=sheet.getRow(row);
			for(int column=0;column<totalcolumns;column++)
			{
				XSSFCell currentCell=currentRow.getCell(column);
				
				 DataFormatter dataformat=new DataFormatter();
				 data[row-2][column]=dataformat.formatCellValue(currentCell);
				 
			}
			
		}
		return data;
		
		/*for(Object i[]:data)
		{
			for(Object j:i)
			System.out.println(j);
		}*/
	}
	
	
	
	

}
