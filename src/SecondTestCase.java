import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondTestCase {

	@Test(priority = 1)
	void setup() {

		System.out.println("This is setup test");

	}

	@Test(priority = 2)
	void SearchCustomer() {

		System.out.println("This is Search customer");
		Assert.assertEquals(1, 1);
	}

	@Test(priority = 3)
	void AddCustomer() {
		System.out.println("Adding Customer");
	}

	@Test(priority = 4)
	void teardown() {
		System.out.println("Closing browser");

	}

}
