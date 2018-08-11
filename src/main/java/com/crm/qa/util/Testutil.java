package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.qa.base.TestBase;

public class Testutil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\User\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\Testdata\\Testdata1.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	
	
	public void switchtoframe() {
		driver.switchTo().frame("mainpanel");
		}
	
	public static Object[][] getTestData(String sheetName) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream file=null;
		
		try {
			file=new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		
		
		
		
		sheet=book.getSheet(sheetName);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				
				data[i][k]=sheet.getRow( i+1 ).getCell(k).toString();
				
			}
			
		}
		
		return data;
		
		
	}
	

}
