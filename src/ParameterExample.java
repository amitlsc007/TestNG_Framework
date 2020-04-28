import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterExample {
	WebDriver driver;

	@BeforeClass
	@Parameters({ "browser", "url" })
	void setup(String browser, String url) {

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
	}

	@Test(priority = 1)
	void logoTest() {
		WebElement logo = driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img"));
		Assert.assertTrue(logo.isDisplayed(), "Log is not dispalyed on the page");

	}

	@Test(priority = 2)
	void homeTitle() {
		String title = driver.getTitle();
		Assert.assertEquals("OrangeHRM", title, "Title not matched");

	}

	@AfterClass
	void tearDown() {
		driver.close();
	}
}
