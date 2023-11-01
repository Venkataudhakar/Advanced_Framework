package Practice;

import org.testng.annotations.Test;

public class TestNG
{
	//@Parameters("browser")
	@Test(groups = {"SmokeSuite","RegressionSuite"})
	public void createCustomer()
	{
		System.out.println("create customer");
	}
	@Test(invocationCount = 1, priority = 1)
	public void modifyCustomer()
	{
		System.out.println("modify customer");
	}
	@Test(enabled = false)
	public void deleteCustomer()
	{
		System.out.println("delete customer");
	}
}
