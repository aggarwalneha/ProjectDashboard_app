package com.mycompany.app.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	private static XSSFSheet ExcelWsheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	
		
	public static String getCellData(int Row, int Col)
	{
		Cell = ExcelWsheet.getRow(Row).getCell(Col);
		String CellValue = Cell.getStringCellValue();
		return CellValue;
		
	}


	public static void setExcelFile(String filePath, String sheetName) throws IOException {
		// TODO Auto-generated method stub
		InputStream fis = new FileInputStream(filePath);
		ExcelWBook = new XSSFWorkbook(fis);
		ExcelWsheet = ExcelWBook.getSheet(sheetName);
	}
	
	
	public static int getLastRowNumber() {
		// TODO Auto-generated method stub
		int LastRowNum = ExcelWsheet.getLastRowNum();
		return LastRowNum;
	}
	
	

}
