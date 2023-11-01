package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertPractice {
	
	@Test
	public void practice1()
	{
		SoftAssert sa=new SoftAssert();
		System.out.println("step1");
		
		System.out.println("step2");
		sa.assertEquals(false, true);
		
		Assert.assertEquals(0, 1);
		System.out.println("step3");
		System.out.println("step4");
		
		
		
		
		

		sa.assertEquals('a', 'b');
		sa.assertAll();
	}

}
