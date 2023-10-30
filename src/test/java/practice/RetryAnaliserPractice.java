package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnaliserPractice {
	
	
	@Test(retryAnalyzer = genericutilities.RetryAnaliserImplementation.class)
	public void retryAnalyserPractice()
	{
		Assert.fail();
		System.out.println("hi");
	}

}
