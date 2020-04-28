package extentReport;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.sun.jna.platform.FileUtils;

public class GenerateExtentReport {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;  //specify the location of the report
	ExtentTest test;	//what details should be populated in the report
	WebDriver driver ;
	
	@BeforeTest
	public void setextent() {
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/myReport.html");
		htmlReporter.config().setDocumentTitle("Automation Report"); //Title of report 
		htmlReporter.config().setReportName("Functional Report"); //Name of report
		htmlReporter.config().setTheme(Theme.DARK);
	
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Hostname", "Local host");
		extent.setSystemInfo("OS","Window10");
		extent.setSystemInfo("Tester name","Amit");
		extent.setSystemInfo("Browser","Chrome");

	}
	@AfterTest
	public void endReport() {
		extent.flush();
	
	}
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.gecko.driver","geckodriver.exe");
    	driver = new FirefoxDriver();
    	driver.get("https://demo.nopcommerce.com");
	}
	
	@Test
	public void nopCommerceTitleTest() {
		test=extent.createTest("nopCommerceTitleTest");
		String title=	driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("nopCommerce demo store", title, "Title not matched");
						
	}
	@Test
	public void nopCommerceLogoTest() {
		test=extent.createTest("nopCommerceLogoTest");
		Boolean status=driver.findElement(By.xpath("//div[@class='header-logo']//a//img")).isDisplayed();
		Assert.assertTrue(status);
			
	}
	
	@Test
	public void nopCommerceLoginTest() {
		test=extent.createTest("nopCommerceLoginTest");
		Assert.assertTrue(true);
			
	}
	
	public void tearDown(ITestResult result)throws IOException {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL,"TEST CASE FAILED IS" +result.getName()); //to add name in extent report
			test.log(Status.FAIL,"TEST CASE FAILED IS" +result.getThrowable()); //to add error/exception in report
			
			String screenShotPath=GenerateExtentReport.getScreenshot(driver,result.getName());
			test.addScreenCaptureFromPath(screenShotPath);//adding screen shot
		
		}else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP,"Test case Skipped is" +result.getName());
			
		}else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS,"Test case passed is" +result.getName());
			
		}
		
	}
	
	public static String getScreenshot(WebDriver driver,String screenshotName) throws IOException {
		String dateName=new SimpleDateFormat("yyyy/mmddhhmmss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot)driver ;
		File source=ts.getScreenshotAs(OutputType.FILE);
		
		//after execution we could see a folder "FailedTestsScreenshots" under src folder
		String destination=System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination=new File(destination);
		org.apache.commons.io.FileUtils.copyFile(source,finalDestination);
		return destination;
	}
}
