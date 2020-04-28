package Listener;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
	
	@Test()
	void loginByEmail() {
		System.out.println("Login By Email");
		Assert.assertEquals("amit", "amit");//true
	}
	
	@Test
	void loginByFacebook() {
		System.out.println("Login By Facebook");
		Assert.assertEquals("amit", "kumar");//false
	}

}
