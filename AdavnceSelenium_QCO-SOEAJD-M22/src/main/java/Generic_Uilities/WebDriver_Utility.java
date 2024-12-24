package Generic_Uilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class WebDriver_Utility {

	/**
	 * This method is used to maximize the window
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to wait for page to load
	 * 
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	/**
	 * THis method is used to switch windows
	 * 
	 * @param driver
	 * @param partialTitle
	 */
	public void windowSwtiching(WebDriver driver, String partialTitle) {
		Set<String> allWins = driver.getWindowHandles();
		Iterator<String> id = allWins.iterator();

		while (id.hasNext()) {
			String win = id.next();
			driver.switchTo().window(win);
			String title = driver.getTitle();
			if (title.contains(partialTitle))

			{
				break;
			}
		}
	}

	public void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void screenShot() {
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./ScreenShots/image.png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

public static String takeScreenShot1(WebDriver driver, String screenShotName) throws Throwable {
		
		TakesScreenshot takesSceenShot = (TakesScreenshot) driver;
		File src = takesSceenShot.getScreenshotAs(OutputType.FILE);
		File dst = new File("./ScreenShots/" + screenShotName +".png");
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
	}
}