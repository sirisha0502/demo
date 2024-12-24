package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Uilities.Excel_Utility;
import Generic_Uilities.Java_Utility;

public class DataProviderEx3 {

	@Test(dataProvider = "readData")
	public void createOrganization(String name, String phnNum, String mailId) throws Throwable {

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();

		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		driver.findElement(By.name("accountname")).sendKeys(name+ranNum);
		driver.findElement(By.name("phone")).sendKeys(phnNum);
		driver.findElement(By.name("email1")).sendKeys(mailId);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();

		driver.quit();
	}

	@DataProvider
	public Object[][] readData() throws Throwable
	{
	Excel_Utility elib = new Excel_Utility();	
	Object[][] values = elib.readExcelDataForDataProvider("DataProvider");
		return values;
		
	}
}
