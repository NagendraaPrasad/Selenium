package com.automation.frameworkUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.Reporter;

public class ExcelFactory {
	
	String userdirectory = System.getProperty("user.dir");
	private String Filepath = userdirectory + "\\resources\\TestInputData\\TestData.xls";
	FileInputStream inputstream;
	HSSFWorkbook workbook;
	HSSFSheet sheet;
	public ExcelFactory() {
		// TODO Auto-generated constructor stub
		try {
			inputstream = new FileInputStream(Filepath);
			workbook = new HSSFWorkbook();
			sheet = workbook.getSheet("Sheet1");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getData(String TestCaseID, String SheetName, String Field){
	
		String value ="";
		HSSFRow row;
		int rowNo=0; int colNo=0;
		
		int totalRows = sheet.getPhysicalNumberOfRows();
		
		for(int i = 1; i < totalRows; i++){
			row = sheet.getRow(i);
			String actTestID = row.getCell(0).getStringCellValue();
			if(actTestID.equalsIgnoreCase(TestCaseID)){
				rowNo = i;
				break;
			}
		}
		
		int totalColumns = sheet.getRow(rowNo).getPhysicalNumberOfCells();
		
		for (int j = 0; j < totalColumns; j++) {
			row = sheet.getRow(0);
			String actField = row.getCell(j).getStringCellValue();
			if(actField.equalsIgnoreCase(Field)){
				colNo=j;
				break;
			}
		}
		
		value = sheet.getRow(rowNo).getCell(colNo).getStringCellValue();
		Reporter.log("Value fetched from Datatable");
		return value;
			
	}
	
	public void setData(String TestCaseID, String SheetName, String Field, String value){
		
		HSSFRow row;
		int rowNo=0; int colNo=0;
		
		int totalRows = sheet.getPhysicalNumberOfRows();
		
		for(int i = 1; i < totalRows; i++){
			row = sheet.getRow(i);
			String actTestID = row.getCell(0).getStringCellValue();
			if(actTestID.equalsIgnoreCase(TestCaseID)){
				rowNo = i;
				break;
			}
		}
		
		int totalColumns = sheet.getRow(rowNo).getPhysicalNumberOfCells();
		
		for (int j = 0; j < totalColumns; j++) {
			row = sheet.getRow(0);
			String actField = row.getCell(j).getStringCellValue();
			if(actField.equalsIgnoreCase(Field)){
				colNo=j;
				break;
			}
		}
		
		HSSFCell cell = sheet.getRow(rowNo).createCell(colNo);
		cell.setCellValue(value);
		Reporter.log("Value written in Datatable");
			
	}

}
