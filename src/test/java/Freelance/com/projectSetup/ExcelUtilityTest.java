package Freelance.com.projectSetup;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExcelUtilityTest {

    private File tempDir;

    @BeforeMethod
    public void setup() throws IOException {
        tempDir = Files.createTempDirectory("exceltest").toFile();
        // set data dir and required credentials before VARIABLES class initialises
        System.setProperty("data.dir", tempDir.getAbsolutePath());
        System.setProperty("bsb.email", "test@example.com");
        System.setProperty("bsb.password", "secret");

        // create a simple Excel file at the expected path
        File excel = new File(VARIABLES.EXCEL_FILE_PATH);
        excel.getParentFile().mkdirs();
        try (XSSFWorkbook wb = new XSSFWorkbook(); FileOutputStream fos = new FileOutputStream(excel)) {
            XSSFSheet sheet = wb.createSheet(VARIABLES.SHEET_NAME);
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("col1");
            header.createCell(1).setCellValue("col2");

            Row row1 = sheet.createRow(1);
            row1.createCell(0).setCellValue("value1");
            row1.createCell(1).setCellValue("value2");

            wb.write(fos);
        }
    }

    @AfterMethod
    public void teardown() {
        // cleanup temp data.dir
        if (tempDir != null && tempDir.exists()) {
            deleteRecursively(tempDir);
        }
    }

    private void deleteRecursively(File f) {
        if (f.isDirectory()) {
            for (File c : f.listFiles()) {
                deleteRecursively(c);
            }
        }
        f.delete();
    }

    @Test
    public void readExcelData_shouldReturnRows() {
        Object[][] data = ExcelUtility.getExcelData();
        Assert.assertNotNull(data, "Returned data should not be null");
        Assert.assertTrue(data.length >= 1, "Expected at least one data row");
        Object[] first = data[0];
        Assert.assertEquals(first[0], "value1");
        Assert.assertEquals(first[1], "value2");
    }
}
