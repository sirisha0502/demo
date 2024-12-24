package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CampValidatePage {

	public CampValidatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/**
	 * 
	 * @param driver
	 * @param CampName
	 * @return
	 */
	public String validateCampaign(WebDriver driver,String CampName)
	{
		String actData = driver.findElement(By.id("dtlview_Campaign Name")).getText();
		return actData;

//		if (actData.contains(CampName)) {
//			System.out.println("Campaign Name is Created");
//		} else {
//			System.out.println("Campaign Name is not Created");
//		}
//		return actData;

	}
	/**
	 * 
	 */
	public String validatePrdoct(WebDriver driver,String PrdName)
	{
		String actData1 = driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();

		if (actData1.contains(PrdName)) {
			System.out.println("Product Name is created");
		} else {
			System.out.println("Product Name is not Created");
		}
		return actData1;
	}
	
}
