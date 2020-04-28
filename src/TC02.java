import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TC02 {
	@BeforeClass
	void beforeClass() {

		System.out.println("This will execute before the class");
	}

	@AfterClass
	void afterClass() {

		System.out.println("This will execute after the class");
	}

	@BeforeMethod
	void BeforeMethod() {

		System.out.println("This will execute before every method");
	}

	@AfterMethod
	void AfterMethod() {
		System.out.println("This will execute After every method ");

	}

	@Test
	void test3() {
		System.out.println("THis is 3dr testcase..");
	}

	@Test
	void test4() {

		System.out.println("This is 4th test case..");
	}

	@BeforeSuite
	void beforeSuite() {
		System.out.println("This will execute before Suite ");
	}

	@AfterSuite
	void afterSuite() {
		System.out.println("This will execute after suite");
	}
}
