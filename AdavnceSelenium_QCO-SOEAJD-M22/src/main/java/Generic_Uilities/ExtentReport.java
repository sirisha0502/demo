package Generic_Uilities;

import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ExtentReport implements ITestListener {
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		test= report.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
		System.out.println("Script Pass");
	}

	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		
		test.log(Status.FAIL, testName + "==>Failed==<");
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
////		System.out.println("Script fail");
//
//		System.out.println("----------im taking ScreenShot-----");
		String screenshot=null;
		try {
			screenshot = WebDriver_Utility.takeScreenShot1(BaseClass.sdriver, result.getMethod().getMethodName());

		} catch (Throwable e) {

			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(screenshot);
		}
		
	
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
		System.out.println("Script SKIP");
	
		
	}

	public void onStart(ITestContext context) {
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
//		Java_Utility ran = new Java_Utility();
//		int ranNum = ran.getRandomNum();
		
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReportGen/Report.html"+time);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("VtigerReports");
		spark.config().setReportName("Shobha");
		
		//system configure
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("platform", "windows");
		report.setSystemInfo("executedBy", "SHOBHA");
		report.setSystemInfo("reviewedby", "Rathin");

	}

	public void onFinish(ITestContext context) {

		report.flush();
	}
	

}
