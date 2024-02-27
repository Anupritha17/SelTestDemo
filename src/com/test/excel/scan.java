package com.test.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.apache.hc.client5.http.impl.classic.MainClientExec;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class scan {

	public void ReadFile() throws IOException {

		FileInputStream fs = new FileInputStream("C:\\Users\\AJOHNMAR\\Downloads\\ExcelExport.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet1 = workbook.getSheetAt(1);
		Scanner src = new Scanner(System.in);
		String EmpID = src.nextLine();
		for (Row row : sheet1) {
			if (row.getCell(0).toString().equals(EmpID)) {
				for (Cell cell : row) {
					DataFormatter fmt = new DataFormatter();
					CellReference cr = new CellReference(cell);
					System.out.println("Cell " + cr.formatAsString() + " is " + fmt.formatCellValue(cell));
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

	}

	public static void main(String[] args) throws IOException {
		scan Sc = new scan();
		Sc.ReadFile();
	}
}