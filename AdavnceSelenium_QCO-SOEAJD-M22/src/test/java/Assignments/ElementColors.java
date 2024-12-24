package Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementColors {
//pull back
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("field-keywords")).sendKeys("iphone",Keys.ENTER);
//List<WebElement> allColors = driver.findElements(By.xpath("//span[text()='Apple iPhone 13 (128GB) - Starlight']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']//div[@class='a-section a-spacing-none a-spacing-top-mini s-color-swatch-container-list-view']//a"));
	
		 List<WebElement> allColors = driver.findElements(By.xpath("//span[text()='Apple iPhone 13 (128GB) - Midnight']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']//div[@class='a-section a-spacing-none a-spacing-top-mini s-color-swatch-container-list-view']//a"));
	for (WebElement color : allColors)
	{
		String value = color.getAttribute("aria-label");
		System.out.println(value);
	}
	
	
	
	}

}
