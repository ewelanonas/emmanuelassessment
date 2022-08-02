package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadXLSData {

	@DataProvider (name = "TestData.xlsx")
	public String[][] getdata(Method m) throws EncryptedDocumentException, IOException {
		
		/*Converting method reflector to sheet name*/
		String excelSheetName = m.getName();
		
		/* Creating an Excel File Read */
		File f = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\testdata.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet(excelSheetName);
		
		/* Rows */
		int totalRows = sheetName.getLastRowNum(); 
		System.out.println(totalRows);

		/* Columns */
		Row rowCells = sheetName.getRow(0); 
		int totalCols = rowCells.getLastCellNum();
		System.out.println(totalCols);

		/* Processing the Data */
		DataFormatter format = new DataFormatter();
		String testData[][] = new String[totalRows][totalCols];
		
		/* Getting all the data - NOTE: row is 0, since the header is included */
		for (int rows = 1; rows <= totalRows; rows++) {
			for (int cols = 0; cols < totalCols; cols++) {
				testData[rows - 1][cols] = format.formatCellValue(sheetName.getRow(rows).getCell(cols));
				System.out.println(testData[rows - 1][cols]);
			}
		}

		return testData;
	}
}
