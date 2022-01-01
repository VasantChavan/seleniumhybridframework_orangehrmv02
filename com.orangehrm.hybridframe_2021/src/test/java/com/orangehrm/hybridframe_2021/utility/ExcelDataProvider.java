package com.orangehrm.hybridframe_2021.utility;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	public static XSSFWorkbook workbook;

	public static XSSFCell cell;

	public ExcelDataProvider(String excelDataPath) {
		try {

			File fs = new File(excelDataPath);
			FileInputStream fins = new FileInputStream(fs);

			workbook = new XSSFWorkbook(fins);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

//	public void setCellvalue(String sheetname, String cellValue, String excelFilePath, int row) {
//		try {
//
//			XSSFSheet sheet = workbook.getSheet(sheetname);
//			cell = sheet.getRow(row).createCell(sheet.getRow(row).getLastCellNum());
//			cell.setCellValue(cellValue);
//			FileOutputStream fout = new FileOutputStream(excelFilePath);
//			workbook.write(fout);
//			fout.close();
//			System.out.println("Done with writing");
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//
//	public static void main(String[] args) {
//		String excelDataPath = "./Data/TestData.xlsx";
//		ExcelDataProvider excelData = new ExcelDataProvider(excelDataPath);
//		excelData.setCellvalue("Sheet2", "Status", excelDataPath, 0);
//		excelData.setCellvalue("Sheet2", "Pass", excelDataPath, 1);
//	}

	public Object[][] getExcelData(String sheetname) {

		XSSFSheet sheet = workbook.getSheet(sheetname);
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();

		Object data[][] = new Object[rows][cols];

		for (int i = 0; i < rows; i++) {

			for (int j = 0; j < cols; j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}
		return data;
	}

	public Object[][] getExcelData(int index) {

		XSSFSheet sheet = workbook.getSheetAt(index);
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();

		Object data[][] = new Object[rows][cols];

		for (int i = 0; i < rows; i++) {

			for (int j = 0; j < cols; j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}

		return data;
	}

	public int getNumericCellData(String sheetname, int row, int col) {
		return (int) workbook.getSheet(sheetname).getRow(row).getCell(col).getNumericCellValue();
	}

	public int getNumericCellData(int sheetindex, int row, int col) {
		return (int) workbook.getSheetAt(sheetindex).getRow(row).getCell(col).getNumericCellValue();
	}

	public String getStringCellData(String sheetname, int row, int col) {
		return workbook.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
	}

	public String getStringCellData(int sheetindex, int row, int col) {
		return workbook.getSheetAt(sheetindex).getRow(row).getCell(col).getStringCellValue();
	}

}
