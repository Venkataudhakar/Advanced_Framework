package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Practice
{
	@Test
	public void test()
	{
		System.out.println("Step 1");
		System.out.println("Step 2");

		Assert.assertTrue(false);

		System.out.println("Step 3");
		System.out.println("Step 4");
	}
}


