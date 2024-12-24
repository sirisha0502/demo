package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FetchingSingleDataFromExcel {

	public static void main(String[] args) throws Throwable {

		// step1:- Path setting of the Excel file
	//	FileInputStream fis = new FileInputStream("./src/test/resources/TestData11.xlsx");
		FileInputStream fis = new FileInputStream("C:\\Users\\Shobha\\Documents\\TestData11.xlsx");
		
		//step2:- keep the File in read mode
		Workbook book = WorkbookFactory.create(fis);
	
	   //step3:- Navigating to the sheet
		Sheet sheet = book.getSheet("Sheet1");
	
		//Step4:- Navigating to the Row
		Row row = sheet.getRow(0);
	
		//Step5:- Navigating to the Cell
		Cell cell = row.getCell(0);
	
		  String ExcelData = cell.getStringCellValue();
		System.out.println(ExcelData);
		
	}

}
