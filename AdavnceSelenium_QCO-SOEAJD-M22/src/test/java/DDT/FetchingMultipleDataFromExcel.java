package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingMultipleDataFromExcel {

	public static void main(String[] args) throws Throwable {

		FileInputStream fis = new FileInputStream("C:\\Users\\Shobha\\Documents\\TestData11.xlsx");

		Workbook book = WorkbookFactory.create(fis);

		Sheet sheet = book.getSheet("Sheet2");
		
		int rowNum = sheet.getLastRowNum()+1;
        System.out.println(rowNum);
        
        for (int i = 0; i <rowNum; i++)
        {
        	Row row = sheet.getRow(i);
		
//        for (int j = 0; j < row.getLastCellNum(); j++)
//        {
        	Cell cell = row.getCell(0);
        	String links = cell.getStringCellValue();
        	System.out.println(links);
//		}
        }
        
	}

}
