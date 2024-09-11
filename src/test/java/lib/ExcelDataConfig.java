package lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelDataConfig {
	
	XSSFWorkbook wb;
	
	XSSFSheet sheet1;
	
	public ExcelDataConfig(String excelPath){
		
		try{
			
		File src=new File(excelPath);
		FileInputStream fis= new FileInputStream(src);
		wb=new XSSFWorkbook(fis);
		
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public XSSFSheet getSheet(int sheetIndex){
		
		XSSFSheet sheet = wb.getSheetAt(sheetIndex);
		
		
		return sheet;
		
	}
	
	public HashMap<String, Integer> getRowColumnCount(XSSFSheet sheet){
		
		HashMap<String,Integer> rowColCountMap=new HashMap<String,Integer>();
		
		int NoOfRow = sheet.getLastRowNum();
		int NoOfColumn = sheet.getRow(NoOfRow).getLastCellNum();
		
		rowColCountMap.put("NoOfRow", NoOfRow);
		rowColCountMap.put("NoOfColumn", NoOfColumn);
		
		return rowColCountMap;
	}
	
	
	public Object[][] getAllDataFromSheet(XSSFSheet sheet){
		
		int NoOfRow = sheet.getLastRowNum();
		System.out.println("NoOfRow---->"+NoOfRow);
		int NoOfColumn = sheet.getRow(NoOfRow).getLastCellNum();
		System.out.println("NoOfColumn----->"+NoOfColumn);		
				
		
		Object[][] data= new Object[NoOfRow+1][NoOfColumn];
	
		/*
		 * Excel sheet, row and column indexes start from 0.
		*/
		for (int i = 0; i < NoOfRow+1; i++) {

	        Row row = sheet.getRow(i);

	        //Create a loop to print cell values in a row

	        for (int j = 0; j < NoOfColumn; j++) {

	            //Print excel data in console

	            data[i][j]= row.getCell(j).getStringCellValue();
	        }

	}
		
		return data;
	}

}
