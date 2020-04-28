package Listener;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(Listener.CustomListener.class)
public class ListenerTest {
	@Test
	void test1() {
		System.out.println("This is Test1 ");
		Assert.assertEquals("A", "A");
	}
	
	@Test
	void test2()
	{
		System.out.println("This is Test2 ");
		Assert.assertEquals("A", "B");	
	}
	
	@Test
	void test3() {

		System.out.println("This is Test3 ");
		throw new SkipException("This is skipped Exception");	
	}
}
