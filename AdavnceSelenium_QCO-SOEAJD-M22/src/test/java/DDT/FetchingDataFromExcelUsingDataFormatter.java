package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingDataFromExcelUsingDataFormatter {

	public static void main(String[] args) throws Throwable {
		
		// step1:- Path setting of the Excel file
				FileInputStream fis = new FileInputStream("./src/test/resources/TestData11.xlsx");

				//step2:- keep the File in read mode
				Workbook book = WorkbookFactory.create(fis);
			
			   //step3:- Navigating to the sheet
				Sheet sheet = book.getSheet("Sheet1");
			
				//Step4:- Navigating to the Row
				Row row = sheet.getRow(0);
			
				//Step5:- Navigating to the Cell
				Cell cell = row.getCell(0);
				
				DataFormatter format = new DataFormatter();
				String ExcelData = format.formatCellValue(cell);
				System.out.println(ExcelData);
	}

}
