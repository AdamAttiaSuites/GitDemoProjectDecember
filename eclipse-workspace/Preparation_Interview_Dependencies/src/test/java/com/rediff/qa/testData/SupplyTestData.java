package com.rediff.qa.testData;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class SupplyTestData {

	public static FileInputStream ip;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;

	@DataProvider(name = "RediffDataProviderSupply")
	public static Object[][] dataSupplyFrom2DimentionalObjectArray() {
		Object[][] data = { { "Seleniumpanda@rediffmail.com", "Selenium@123" }, 
//				{ "abdouattia27@gmail.com", "Selenium@123" },
//				{ "Abdouattia28@rediffmail.com", "Selenium@123" },
//				{ "Abdouattia29@rediffmail.com", "Selenium@123" } 
				};
		return data;
	}
	@DataProvider(name = "RediggExcelData")
	public static Object[][] excellSheetDataSupply() throws Exception {
		Object[][] data = SupplyTestData.getRedifftestDataFromExcelSheet("Login");
		return data;
	}

	public static Object[][] getRedifftestDataFromExcelSheet(String sheetName) throws Exception {
		// Step 1 - Create Object of file Input String
		String getString = System.getProperty("user.id");
		ip = new FileInputStream(getString+ "/src/test/java/com/rediff/qa/testData/BookTutorialsNinjaData.xlsx");
		// Step 2 - Create Object of XSSFWorkBook
		workbook = new XSSFWorkbook(ip);

		// Step 3 - XSSFSHEET
		sheet = workbook.getSheet(sheetName);

		// Step 4 - Determine number of Rows
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rows][cols];
		for (int i = 0; i < rows; i++) {
			XSSFRow row = sheet.getRow(i + 1);

			for (int j = 0; j < cols; j++) {
				XSSFCell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				switch (cellType) {
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;

				case NUMERIC:
					data[i][j] = Integer.toString((int) cell.getNumericCellValue());

				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
				}
			}
		}
		return data;
	}

}
