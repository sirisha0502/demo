package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwitchingWindowCampWithProd {

	public SwitchingWindowCampWithProd(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[alt=\"Select\"]")
	private WebElement prdPlusImg;
	
	@FindBy(name = "search_text")
	private WebElement productName;
	
	@FindBy(name = "search")
	private WebElement searchBar;
	
	public void clickPlusSign()
	{
		prdPlusImg.click();
	}
	
	public void enterPrdNameInCamp(String name)
	{
		productName.sendKeys(name);
	}
	
	public void clickSearchBar()
	{
		searchBar.click();
	}
	
	public void clickProductName(WebDriver driver,String PrdName)
	{
		driver.findElement(By.xpath("//a[text()='" + PrdName + "']")).click();

	}
}
