package Practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice
{
	@Test
	public void assertion()
	{
		SoftAssert sa = new SoftAssert();
		System.out.println(1);
		System.out.println(2);
		
	//	Assert.assertEquals(1, 0);
	//	Assert.assertTrue(true);
		
	/*	if (1==0)
		{
			System.out.println("PASS");
		} else 
		{
			System.out.println("FAIL");
		}
	*/
		
		sa.assertEquals(false, true);
		
		System.out.println(3);
		System.out.println(4);
	}
}
