package Organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.lang3.Validate;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
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
import ObjectRepo.CreateOrganizationPage;
import ObjectRepo.LoginVtigerPage;
import ObjectRepo.OrgValidatePage;
import ObjectRepo.OrganizationDetailedPage;
import ObjectRepo.VtigerHomePage;
@Listeners(Generic_Uilities.ExtentReport.class)
public class CreateOrganizationTest extends BaseClass {

	@Test(groups = "Regression")
	public void createOrganizationTest() throws Throwable {

		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickOrgLink();

		OrganizationDetailedPage plusImg = new OrganizationDetailedPage(driver);
		plusImg.clickPrdLoopUpImg();

//-----------------------------------------------------------------------------------------------------------
		// RanDom Class----->generating unique values(Avoid Duplicate value)
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
//----------------------------------------------------------------------------------------------------------		

		Excel_Utility elib = new Excel_Utility();
		String OrgName = elib.readExcelData("Organization", 0, 0) + ranNum;
// --------------------------------------------------------------------------------------------------------------------------------

		String phnNum = elib.readExcelDataUsingDataFormatter("Organization", 1, 0);
// ----------------------------------------------------------------------------------------------------------------------------

		String emailId = elib.readExcelDataUsingDataFormatter("Organization", 2, 0);
//----------------------------------------------------------------------------------------------------------

		CreateOrganizationPage orgPage = new CreateOrganizationPage(driver);
//		orgPage.enterOrgName(OrgName);
//		orgPage.enterPhnNum(phnNum);
//		orgPage.enterEmailId(emailId);
		// or
		orgPage.enterOrgData(OrgName, phnNum, emailId);
		orgPage.clickSaveButton();

//-------------------------------------------------------------------------------------------------------------
		Thread.sleep(2000);
		OrgValidatePage Validate = new OrgValidatePage(driver);
		String actData = Validate.validateOrganization(driver, OrgName);

		Assert.assertEquals(actData, OrgName);
		System.out.println("Organization Name is Created");
		
//----------------------------------------------------------------------------------------------------------

	}

}
