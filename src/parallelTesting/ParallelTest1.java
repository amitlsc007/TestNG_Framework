package parallelTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ParallelTest1 {
	WebDriver driver;
	
	@Test
	void logoTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		WebElement logo = driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img"));
		Assert.assertTrue(logo.isDisplayed(), "Log is not dispalyed on the page");
		Thread.sleep(5000);
	}
	
@Test
void homepageTitle() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://opensource-demo.orangehrmlive.com/");
	String title=	driver.getTitle();
	Assert.assertEquals("OrangeHRM", title, "Title not matched");
	Thread.sleep(5000);
}
 @AfterMethod
void tearDown() {
	driver.quit();
}

}
