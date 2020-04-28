import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AssestionExamples {

	WebDriver driver;
	@BeforeClass
	void setup() {
		System.setProperty("webdriver.gecko.driver","geckodriver.exe");
    	driver = new FirefoxDriver();
    	driver.get("https://opensource-demo.orangehrmlive.com");
}
	@Test
	void logoTest() {
	WebElement logo=	driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img"));
	Assert.assertTrue(logo.isDisplayed(),"Log is not dispalyed on the page");
	
//	Assert.assertFalse(logo.isDisplayed(), "Log is not dispalyed on the page");
	}
	
	
	@Test
	void homeTitle() {
	String title=	driver.getTitle();
	Assert.assertEquals("OrangeHRM", title, "Title not matched");
	
	//Assert.assertEquals("OrangeHRM123", title, "Title not matched");//fail test case
	}
	
@AfterClass
void tearDown() {
	driver.close();
}
}
