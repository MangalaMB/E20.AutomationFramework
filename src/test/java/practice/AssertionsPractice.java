package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
	
	
	
	
	@Test(retryAnalyzer = genericUtilities.RetryAnalyserImplementation.class)
	public void sample()
	{
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
//		if(1==0)
//		{
//			System.out.println("PASS");
//		}
//		else
//		{
//			System.out.println("FAIL");
//		}
		
		Assert.assertEquals(0, 1);
		
		System.out.println("Step 4");
		System.out.println("Step 4");
		System.out.println("Step 4");
		System.out.println("Step 4");
		
		
		
		System.out.println("Step 5");
		System.out.println("Step 6");
	}

	@Test
	public void samplesoft()
	{
		SoftAssert sa = new SoftAssert();
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
		sa.assertEquals(0, 1);//f
		
		System.out.println("Step 4");
		System.out.println("Step 5");
		System.out.println("Step 6");
		
		sa.assertAll();//log
	}

}
