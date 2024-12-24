package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertSignleDataIntoExcel {

	public static void main(String[] args) throws Throwable {

		// Keep Excel file in Read Mode
		FileInputStream fis = new FileInputStream("C:\\Users\\Shobha\\Documents\\TestData11.xlsx");

		Workbook book = WorkbookFactory.create(fis);

		Sheet sheet = book.getSheet("Sheet1");
		Row row = sheet.createRow(5);
		Cell cell = row.createCell(5);
		cell.setCellValue("Qspiders");

		// Keep Excel file in write Mode
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Shobha\\Documents\\TestData11.xlsx");
		book.write(fos);
		book.close();

	}

}
