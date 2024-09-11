package ReadExcelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * Excel sheet, row and column indexes start from 0.
*/

public class ReadExcel {
	
	public static void main(String args[]) throws IOException{
		
		File file= new File("F:\\ExcelData\\TestData.xlsx");
		
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		// Select the excel sheet.
		XSSFSheet sheet1 = wb.getSheetAt(0);
		
		int rowCount = sheet1.getLastRowNum();
		System.out.println("rows: "+rowCount);
		System.out.println("rowCount"+rowCount);
		
		for (int i = 0; i < rowCount+1; i++) {

	        Row row = sheet1.getRow(i);

	        //Create a loop to print cell values in a row

	        for (int j = 0; j < row.getLastCellNum(); j++) {

	            //Print excel data in console
	        	System.out.println("columnCount"+row.getLastCellNum());
	            System.out.print(row.getCell(j).getStringCellValue()+"|| ");

	        }
	        
	       // Code to write data in a particular cell.
	        row.createCell(2).setCellValue("Pass");
	        FileOutputStream fos = new FileOutputStream(file);
	        wb.write(fos);

	}
		wb.close();

}
}