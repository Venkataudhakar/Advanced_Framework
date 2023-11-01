package Practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion 
{
	@Test
	public void softAssertion()
	{
		SoftAssert sa = new SoftAssert();
		System.out.println(1);
		System.out.println(2);
		
		sa.assertEquals(false, true);//failed
		sa.assertAll();
		
		System.out.println(3);
		System.out.println(4);
	}
}
