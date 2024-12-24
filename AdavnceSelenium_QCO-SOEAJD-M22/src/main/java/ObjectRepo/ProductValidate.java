package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductValidate {

	public ProductValidate(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String validatePrdoct(WebDriver driver, String PrdName) {
		String actData = driver.findElement(By.id("dtlview_Product Name")).getText();

//					if (actData.contains(PrdName)) {
//						System.out.println("Product Name is created");
//					} else {
//						System.out.println("Product Name is not Created");
//					}
		return actData;

	}
}
