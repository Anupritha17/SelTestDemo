package com.test.excel;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NumericTets {
	public void numStr(XSSFSheet sh) {
		// Iterate each row one by one
		
		Iterator<Row> rIterator = sh.iterator();
		while (rIterator.hasNext()) {
			Row row = rIterator.next();

			// For each row, iterate through all the columns
			Iterator<Cell> Cell = row.cellIterator();

			while (Cell.hasNext()) {
				Cell cell = Cell.next();

				// Check the cell type
				switch (cell.getCellType()) {
				case STRING:
					System.out.print(cell.getStringCellValue());
					break;

				case NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;
				default:
					break;
				}
				System.out.print("|");
			}
			
		}
	}
	
	public void ReadNum(XSSFSheet sh ,String EmpID){
		for(Row row:sh ) {
			if(row.getCell(0).toString().equals(EmpID)) {
				for(Cell cell: row) {
					switch (cell.getCellType()) {
					case STRING:
						System.out.print(cell.getStringCellValue());
						System.out.println();
						break;
	
					case NUMERIC:
						System.out.print(cell.getNumericCellValue());
						System.out.println();
						break;
					default:
						break;
					}
					
				}
				
			}
		}
		
//		wb.close();
//		fs.close();
	}

//	public static void main(String[] args) throws IOException {
//		NumericTets obj = new NumericTets();
//		obj.ReadNum();
//	}
}
