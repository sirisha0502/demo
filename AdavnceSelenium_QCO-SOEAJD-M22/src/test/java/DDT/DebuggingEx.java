package DDT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import demo.Method;

public class DebuggingEx {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
	//	driver.manage().window().maximize();
		
		Method ele = new Method();
		ele.maximizeWindow(driver);
	}

}
