package Campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import org.testng.annotations.Test;

import Generic_Uilities.BaseClass;
import Generic_Uilities.Excel_Utility;
import Generic_Uilities.File_Utility;
import Generic_Uilities.Java_Utility;
import Generic_Uilities.WebDriver_Utility;
import ObjectRepo.CampDetailedPage;
import ObjectRepo.CampValidatePage;
import ObjectRepo.CreateCampPage;
import ObjectRepo.CreateProductPage;
import ObjectRepo.LoginVtigerPage;
import ObjectRepo.ProductDetailedPage;
import ObjectRepo.SwitchingWindowCampWithProd;
import ObjectRepo.VtigerHomePage;

public class CreateCampaignWithProductTest extends BaseClass {

	
	
	@Test(groups = "smoke")
	public void createCampaignWithProductTest() throws Throwable {

		WebDriver_Utility wlib = new WebDriver_Utility();
		File_Utility flib = new File_Utility();
		Excel_Utility elib = new Excel_Utility();
		Java_Utility jlib = new Java_Utility();

		String URL = flib.getKeyAndValuePair("url");
		String USERNAME = flib.getKeyAndValuePair("username");
		String PASSWORD = flib.getKeyAndValuePair("password");

//		if (BROWSER.equalsIgnoreCase("chrome")) {
//			driver = new ChromeDriver();
//		} else if (BROWSER.equalsIgnoreCase("firefox")) {
//			driver = new FirefoxDriver();
//		} else if (BROWSER.equalsIgnoreCase("edge")) {
//			driver = new EdgeDriver();
//		} else {
//			driver = new ChromeDriver();
//		}
//		wlib.maximizeWindow(driver);
//		wlib.waitForPageToLoad(driver);
//		driver.get(URL);

		// using business logics
//		LoginVtigerPage login = new LoginVtigerPage(driver);
//		login.loginIntoVtiger(USERNAME, PASSWORD);

		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickPrdLink();

		ProductDetailedPage prdPlus = new ProductDetailedPage(driver);
		prdPlus.clickPrdLookUpImg();

		// RanDom Class----->generating unique values(Avoid Duplicate value)

		int ranNum = jlib.getRandomNum();
		// ----------------------------------------------------------------------------------------------------------

		String PrdName = elib.readExcelData("Product", 0, 0) + ranNum;
		System.out.println(PrdName);

		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.enterPrdName(PrdName);
		prdPage.clickSaveButton();

//------------------------------------------------------------------------------------------------------
		home.clickMoreLink();
		home.clickCampLink();

		CampDetailedPage plusCamp = new CampDetailedPage(driver);
		plusCamp.clickCampLookUpImg();

		// ----------------------------------------------------------------------------------------------------------

		String CampName = elib.readExcelData("Campaign", 0, 0) + ranNum;

		System.out.println(CampName);

		CreateCampPage campPage = new CreateCampPage(driver);
		campPage.enterCampName(CampName);

		SwitchingWindowCampWithProd winSwitch = new SwitchingWindowCampWithProd(driver);
		winSwitch.clickPlusSign();

		wlib.windowSwtiching(driver, "Products&action");

		winSwitch.enterPrdNameInCamp(PrdName);
		winSwitch.clickSearchBar();

		Thread.sleep(2000);

		// Dynamic xpath

		winSwitch.clickProductName(driver, PrdName);

		wlib.windowSwtiching(driver, "Campaigns&action");

		campPage.clickSaveButton();

		CampValidatePage validate = new CampValidatePage(driver);
		validate.validateCampaign(driver, CampName);
		validate.validatePrdoct(driver, PrdName);

		// -------------------------------------------------------------------------------------

		// home.logoutApp();

	}

}
