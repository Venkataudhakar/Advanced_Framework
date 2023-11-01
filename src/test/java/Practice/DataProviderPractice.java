package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice 
{
	@Test(dataProvider = "getData")
	public void addProductToCart(String Name, int price, int Qty, String model)
	{
		System.out.println("Phone name is:"+Name+"Phone price is:"+price+"Quantity is:"+Qty+"Model is:"+model);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[3][4];//3 sets od data with 4 details
		
		data[0][0] = "Samsung";
		data[0][1] = 10000;
		data[0][2] = 10;
		data[0][3] = "A80";
		
		data[1][0] = "Nokia";
		data[1][1] = 2000;
		data[1][2] = 20;
		data[1][3] = "B20";
		
		data[2][0] = "iPhone";
		data[2][1] = 30000;
		data[2][2] = 40;
		data[2][3] = "C20";
				
		return data;
	}
}
