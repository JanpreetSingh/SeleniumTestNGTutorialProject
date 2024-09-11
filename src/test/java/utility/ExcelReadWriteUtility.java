package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * Excel sheet, row and column indexes start from 0.
*/
public class ExcelReadWriteUtility {
	
	FileInputStream fis;
	FileOutputStream fos;
	XSSFWorkbook wb;
	
	public ExcelReadWriteUtility(String excelFilePath) {
		
		File file= new File(excelFilePath);
		
		
		try {
			fis = new FileInputStream(file);		
			fos = new FileOutputStream(file);
			wb = new XSSFWorkbook(fis);
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public String getData(int SheetNumber, int row, int column) {
		
		XSSFSheet sheet = wb.getSheetAt(SheetNumber);
		
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	
	public void setCellData(int SheetNumber, int row, int column, String cellData) {
		
		XSSFSheet sheet = wb.getSheetAt(SheetNumber);
		
		sheet.getRow(row).createCell(column).setCellValue(cellData);
		try {
			wb.write(fos);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public void closeWorksheetObject() {
		try {
			wb.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}



























