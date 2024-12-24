package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationDetailedPage {

	public OrganizationDetailedPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[alt=\"Create Organization...\"]")
	private WebElement prdLookUpImg;
	
	public void clickPrdLoopUpImg()
	{
		prdLookUpImg.click();
	}
}
