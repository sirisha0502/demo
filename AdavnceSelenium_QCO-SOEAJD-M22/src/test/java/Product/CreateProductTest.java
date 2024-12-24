package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

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
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Uilities.BaseClass;
import Generic_Uilities.Excel_Utility;
import Generic_Uilities.File_Utility;
import Generic_Uilities.Java_Utility;
import Generic_Uilities.WebDriver_Utility;
import ObjectRepo.CreateProductPage;
import ObjectRepo.LoginVtigerPage;
import ObjectRepo.ProductDetailedPage;
import ObjectRepo.ProductValidate;
import ObjectRepo.VtigerHomePage;

//@Listeners(Generic_Uilities.Listener.class)
//@Listeners(Generic_Uilities.ExtentReport.class)
public class CreateProductTest extends BaseClass {

	@Test(groups = "sanity")
	public void createProductTest() throws Throwable {

		File_Utility flib = new File_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();

		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickPrdLink();

//		Assert.fail("fail the script");
		ProductDetailedPage plusImg = new ProductDetailedPage(driver);
		plusImg.clickPrdLookUpImg();

		// RanDom Class----->generating unique values(Avoid Duplicate value)

		int ranNum = jlib.getRandomNum();
		// ----------------------------------------------------------------------------------------------------------

		String PrdName = elib.readExcelData("Product", 0, 0) + ranNum;
		System.out.println(PrdName);

		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.enterPrdName(PrdName);
		prdPage.clickSaveButton();

		
		Thread.sleep(2000);

		ProductValidate validate = new ProductValidate(driver);
		validate.validatePrdoct(driver, PrdName);

	}

}
