package com.test.excel;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Apache POI,(Poor Obfuscation Implementation) is an API
//collection of Java libraries that helps us to read, write, and manipulate different Microsoft files such as excel sheets, power-point, and word files.
//.xls or .xlsx
// HSSFSheet - class to create a new sheet in the HSSFWorkbook,  the older format of Excel.
// XSSFSheet - class to create a new sheet in the XSSFWorkbook., the new format of Excel
public class ExcelRead {
	NumericTets numTest = new NumericTets();
	public void ReadFile() {
		try {
//Create an object of FileInputStream class to read excel file
			FileInputStream fs = new FileInputStream("C:\\Users\\AJOHNMAR\\Downloads\\ExcelExport.xlsx");

//Create object of XSSFWorkbook class
			XSSFWorkbook workbook = new XSSFWorkbook(fs);

//Create obejct of XSSFSheet class and read excel
			XSSFSheet sheet1 = workbook.getSheetAt(1);
			XSSFSheet sheet = workbook.getSheetAt(0);
			numTest.numStr(sheet);
			numTest.ReadNum(sheet1, "12");
			

//get row count by getLastRowNum() method.
			int rowcount = sheet.getLastRowNum();// 5

			for (int k = 0; k <= rowcount; k++) {
				XSSFRow row = sheet.getRow(k);
				int cellcount = row.getLastCellNum();// 2

				for (int j = 0; j < cellcount; j++) {
					String temp = row.getCell(j).getStringCellValue();
					System.out.print(temp + "||");
				}
				System.out.println();

			}
//Printing the particular value 
			XSSFRow row = sheet.getRow(1);
			XSSFCell cell0=row.getCell(0);
			System.out.println(cell0);
			XSSFCell cell1 = row.getCell(1);
			System.out.println(cell1);
			XSSFRow row2 = sheet.getRow(2);
			XSSFCell cell2 = row2.getCell(1);
			System.out.println(cell2);
//			Printing the slected row:
			XSSFRow row1 = sheet.getRow(1);
				for(Cell cell:  row1) {
					System.out.print(cell.getStringCellValue()+"|");
				}
			workbook.close();
			fs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
	
		
		ExcelRead obj = new ExcelRead();
		obj.ReadFile();
		
	}

}