package practise;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsPractise {
	
	@Test
	public void sampleTest()
	{
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
		Assert.assertEquals(1, 1);
		System.out.println("Step 4");
		
		Assert.assertEquals(0, 1);
		
		////////////System.out.println("Step 5");
	}

}
