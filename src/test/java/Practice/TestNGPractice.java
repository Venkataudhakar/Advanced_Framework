package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice
{
	@Test
	public void createCustomer()//failded
	{
		Assert.fail();
		System.out.println("create customer");
	}
	@Test(dependsOnMethods = "createCustomer")
	public void modifyCustomer()
	{
		System.out.println("modify customer");
	}
	@Test
	public void deleteCustomer()
	{
		System.out.println("delete customer");
	}
}
