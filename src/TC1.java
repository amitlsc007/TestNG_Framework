import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC1 {
	
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
	void test1() {
		System.out.println("THis is first testcase..");
	}
	@Test
	void test2() {
		
		System.out.println("This is second test case..");
	}
@BeforeTest
	void beforeTest() {
		System.out.println("This will execute before the test");
	}
	
@AfterTest
void afterTest() {
	
	System.out.println("This will execute After the test");
}
}
