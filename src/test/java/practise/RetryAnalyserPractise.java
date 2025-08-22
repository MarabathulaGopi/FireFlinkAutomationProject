package practise;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractise {
	
	@Test(retryAnalyzer = ninzaCRM.genericMethodsPractise.RetryAnalyserImplemenation.class)
	public void sample()
	{
		Assert.fail();
		System.err.println("Sample");
	}

}
