package Freelance.com.projectSetup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelUtility {

	@DataProvider(name = "excelData")
	public static Object[][] getExcelData() {
		File file = new File(VARIABLES.EXCEL_FILE_PATH);
		if (!file.exists()) {
			// Fail loudly so CI never silently passes with 0 tests run.
			throw new RuntimeException(
				"[ExcelUtility] Excel data file not found at: " + file.getAbsolutePath() + "\n" +
				"Set the -Ddata.dir system property to the directory containing the Excel sheet, " +
				"or supply the BSB_DATA_DIR environment variable.");
		}

		Workbook workBook = null;
		Object[][] data = null;

		try (FileInputStream excelFile = new FileInputStream(file)) {
			workBook = WorkbookFactory.create(excelFile);
			Sheet sheet = workBook.getSheet(VARIABLES.SHEET_NAME);

			if (sheet == null) {
				throw new RuntimeException(
					"[ExcelUtility] Sheet '" + VARIABLES.SHEET_NAME + "' not found in " + file.getAbsolutePath());
			}

			int totalRows    = sheet.getLastRowNum();
			int totalColumns = sheet.getRow(0).getLastCellNum();

			ArrayList<Object[]> dataList = new ArrayList<>();
			DataFormatter formatter = new DataFormatter();

			for (int i = 1; i <= totalRows; i++) {
				Row row = sheet.getRow(i);
				if (row == null) continue; // skip completely blank rows
				Object[] rowData = new Object[totalColumns];

				for (int j = 0; j < totalColumns; j++) {
					rowData[j] = formatter.formatCellValue(row.getCell(j));
				}
				dataList.add(rowData);
			}

			data = new Object[dataList.size()][];
			dataList.toArray(data);

		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Error reading excel file: " + e.getMessage());
		} finally {
			if (workBook != null) {
				try {
					workBook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return data;
	}
}
