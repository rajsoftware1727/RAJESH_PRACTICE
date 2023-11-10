package UTILITIES;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow currentRow;
	public static XSSFCell currentCell;

	
	
	 /*
	  * to get total rows
	  */
    public static int totalRows(String sheetName,String path) throws IOException
    {
    	fi=new FileInputStream(path);
        wb=new XSSFWorkbook(fi);
        sheet=wb.getSheet(sheetName);
        return sheet.getPhysicalNumberOfRows();
    }
    

	 /*
	  * to get total columns
	  */
   public static int totalColumns(String sheetName,String path) throws IOException
   {
   	fi=new FileInputStream(path);
       wb=new XSSFWorkbook(fi);
       sheet=wb.getSheet(sheetName);
       return sheet.getRow(1).getPhysicalNumberOfCells();
   }
   
   /*
    * get cell data
    */
   public static Object getcellData(String path,String sheetName,int rowNo,int cellNo) throws IOException
   {
	   fi=new FileInputStream(path);
	   wb=new XSSFWorkbook(fi);
	   sheet=wb.getSheet(sheetName);
	   currentRow=sheet.getRow(rowNo);
	   currentCell=currentRow.getCell(cellNo);
	   DataFormatter data=new DataFormatter();
	   wb.close();
	   fi.close();
	   return data.formatCellValue(currentCell).trim();
	   
	   
	}
   
   public static void  setCellData(String path,String sheetName,int row,int column,Object data) throws IOException
   {
	   fi=new FileInputStream(path);
	   wb=new XSSFWorkbook(fi);
	   currentRow=sheet.getRow(row);
	   currentCell=currentRow.getCell(column);
	   if(data instanceof String)
	   currentCell.setCellValue((String)((String) data).trim());
	   if(data instanceof Integer)
	   currentCell.setCellValue((Integer)data);
	   fo=new FileOutputStream(path);
	   wb.write(fo);
	   wb.close();
	   fi.close();
	   fo.close();
	   
	   
	   
   }
}
