package Campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
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
import ObjectRepo.CampDetailedPage;
import ObjectRepo.CampValidatePage;
import ObjectRepo.CreateCampPage;
import ObjectRepo.CreateProductPage;
import ObjectRepo.LoginVtigerPage;
import ObjectRepo.ProductDetailedPage;
import ObjectRepo.ProductValidate;
import ObjectRepo.VtigerHomePage;

//@Listeners(Generic_Uilities.Listener.class)
@Listeners(Generic_Uilities.ExtentReport.class)
public class CreateCampaignTest extends BaseClass {

//	@Test(retryAnalyzer = Generic_Uilities.RetryImp.class)
	@Test
	public void createCampaignTest() throws Throwable {

		WebDriver_Utility wlib = new WebDriver_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
		File_Utility flib = new File_Utility();

		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickMoreLink();
		home.clickCampLink();

		CampDetailedPage img = new CampDetailedPage(driver);
		img.clickCampLookUpImg();
	
		
		System.out.println("Failing script");

		int ranNum = jlib.getRandomNum();
//----------------------------------------------------------------------------------------------------------		

		String CampName = elib.readExcelData("Campaign", 0, 0) + ranNum;

		CreateCampPage createPage = new CreateCampPage(driver);
		createPage.enterCampName(CampName);

		createPage.clickSaveButton();
	//	Assert.fail();

		CampValidatePage validate = new CampValidatePage(driver);
		String actData = validate.validateCampaign(driver, CampName);
	//	Assert.assertEquals(actData, CampName);
		System.out.println("Campagin Name is created");
		

	}
	
	@Test
	public void m2()
	{
		System.out.println("Hi im Shobha");
	}
	
}
//	=============================================================================================
