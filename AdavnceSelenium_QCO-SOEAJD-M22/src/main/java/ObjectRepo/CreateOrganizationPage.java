package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {

	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement orgName;

	@FindBy(id = "phone")
	private WebElement phnNum;

	@FindBy(id = "email1")
	private WebElement email;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public void enterOrgName(String name) {
		orgName.sendKeys(name);
	}

	public void enterPhnNum(String num) {
		phnNum.sendKeys(num);
	}

	public void enterEmailId(String emailid)

	{
		email.sendKeys(emailid);
	}

	public void enterOrgData(String name,String phoneNum,String emailId)
	{
		orgName.sendKeys(name);
		phnNum.sendKeys(phoneNum);
		email.sendKeys(emailId);
	}
	
	public void clickSaveButton() {
		saveButton.click();
	}
}
