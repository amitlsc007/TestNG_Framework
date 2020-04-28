package Listener;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listeners extends TestListenerAdapter{

	//Invoked after the test class is instantiated and before any configuration method is called.	
	
		public void onStart(ITestContext arg) {
			System.out.println("Starts test execution"+arg.getName());
		}
		//Invoked after all the tests have run and all their Configuration methods have been called.
		public void onFinish(ITestContext arg) {
		
			System.out.println("Finish test execution"+arg.getName());
			
		}
		//Invoked each time before a test will be invoked. The ITestResult is only partially filled with the references to class, method, start millis and status.
		
		public void onTestStart(ITestResult result) {
			
			System.out.println("start test execution"+result.getName());		
			
		}
		
		//Invoked each time a test is skipped.
		public void onTestSkipped(ITestResult result) {
			
			System.out.println("skipped test execution"+result.getName());		
			
		}
		//Invoked each time a test succeeds.
		public void onTestSuccess(ITestResult result) {
			System.out.println("success test execution"+result.getName());		
			
		}
		
		//Invoked each time a test fails.
		public void onTestFailure(ITestResult result) {
			System.out.println("failed test execution"+result.getName());		
			
		}
		//Invoked each time a method fails but has been annotated with successPercentage and this failure still keeps it within the success percentage requested.
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			System.out.println("failed test execution"+result.getName());		

			
		}
		
}
