package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Uilities.BaseClass;
import Generic_Uilities.Excel_Utility;
import Generic_Uilities.File_Utility;
import Generic_Uilities.Java_Utility;
import Generic_Uilities.WebDriver_Utility;
import ObjectRepo.CreateProductPage;
import ObjectRepo.DeleteProductPage;
import ObjectRepo.LoginVtigerPage;
import ObjectRepo.ProductDetailedPage;
import ObjectRepo.ProductValidate;
import ObjectRepo.VtigerHomePage;

public class CreateProductAndDeleteProductTest extends BaseClass {

//	@Test(groups = "sanity")
	public void CreateProductAndDeleteProductTest() throws Throwable {

		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();
		Excel_Utility elib = new Excel_Utility();

		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickPrdLink();

		ProductDetailedPage plusImg = new ProductDetailedPage(driver);
		plusImg.clickPrdLookUpImg();

		int ranNum = jlib.getRandomNum();
		// ----------------------------------------------------------------------------------------------------------

		String PrdName = elib.readExcelData("Product", 0, 0) + ranNum;
		System.out.println(PrdName);

		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.enterPrdName(PrdName);
		prdPage.clickSaveButton();

		ProductValidate validate = new ProductValidate(driver);
		String actData = validate.validatePrdoct(driver, PrdName);
		Assert.assertEquals(actData, PrdName);
		System.out.println("Product Name is Created");

		home.clickPrdLink();

		DeleteProductPage deletePrd = new DeleteProductPage(driver);
		deletePrd.selectPrdCheckBox(driver, PrdName);

		deletePrd.clickDeleteButton();

		wlib.alertAccept(driver);

		actData = deletePrd.validatePrdDeleted(driver, PrdName);
		Assert.assertEquals(actData, PrdName);
		System.out.println("Product Deleted");

		Thread.sleep(2000);
		

	}

}
